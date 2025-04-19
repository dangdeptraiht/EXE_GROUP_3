package controller.Renter;

import dao.RequestDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Account;
import model.ReqType;
import model.RequestList;

import java.util.List;

@WebServlet(name = "EditRequestServlet", urlPatterns = {"/editRequest"})
public class EditRequestController extends HttpServlet {

    private RequestDAO requestDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        requestDAO = new RequestDAO();
    }

    private void populateRequestAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");

        if (account != null) {
            int userID = account.getUserID();
            List<ReqType> requestTypes = requestDAO.getAllReqType();
            request.setAttribute("requestTypes", requestTypes);

            String reqIdParam = request.getParameter("id");
            request.setAttribute("reqID", reqIdParam);
            if (reqIdParam != null) {
                int requestId = Integer.parseInt(reqIdParam);
                RequestList requestDetails = requestDAO.getRequestByReqID(requestId);
                request.setAttribute("requestDetails", requestDetails);
            }
        } else {
            request.setAttribute("message", "User not logged in.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        populateRequestAttributes(request);
        request.getRequestDispatcher("Renter/editRequest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");

        if (account == null) {
            session.setAttribute("message", "User not logged in.");
            response.sendRedirect(request.getContextPath() + "/Renter/contact.jsp");
            return;
        }

        int requestId = Integer.parseInt(request.getParameter("id"));
        int renterID = account.getUserID();
        int requestType = Integer.parseInt(request.getParameter("requestType"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String createAt = request.getParameter("createAt");
        String resStatus = request.getParameter("resStatus");

        boolean updateSuccess = requestDAO.updateRequest(requestId, renterID, requestType, title, description, createAt, resStatus);

        if (updateSuccess) {
            session.setAttribute("message", "Request updated successfully.");
        } else {
            session.setAttribute("message", "Failed to update request.");
        }

        response.sendRedirect( "request");
    }
}
