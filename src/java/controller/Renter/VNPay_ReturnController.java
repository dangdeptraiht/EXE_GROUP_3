package controller.Renter;

import dao.PaymentDAO;
import dao.RenterDAO;
import dao.UserDAO;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Renter;
import utility.VNPayConfig;

@WebServlet(name = "VNPay_ReturnController", urlPatterns = {"/VNPay_ReturnController"})
public class VNPay_ReturnController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        RenterDAO dao = new RenterDAO();
        UserDAO userDAO = new UserDAO();
        PaymentDAO payment = new PaymentDAO();

        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        int flag = (int) session.getAttribute("flag");        
        List<Renter> basicDetailRenter = dao.getRenterDetail(email, password);
        int renterID = 0;
        for (Renter renter : basicDetailRenter) {
            renterID = renter.getRenterID();
        }
        

        Map<String, String> fields = VNPayConfig.getParameterMap(request);

        String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
        if ("00".equals(vnp_ResponseCode)) {
            if (flag == 0) {
                double money = (double) session.getAttribute("money");
                int addMoney = payment.addMoney(money * 1000, renterID);
                int idPayment = (int) session.getAttribute("idPayment");
                int updatePaymentStatus = payment.updatePaymentStatus(idPayment);
                request.setAttribute("message", "Payment success");
                session.removeAttribute("money");
                session.removeAttribute("idPayment");
            } else {
                int userID = (int) session.getAttribute("userID");
                int roomID_BookRoom = (int) session.getAttribute("roomID_BookRoom");
                int addRenter = dao.addRenter(userID, roomID_BookRoom);
                boolean renRoom = dao.rentRoom(roomID_BookRoom);
                session.removeAttribute("userID");
                session.removeAttribute("roomID_BookRoom");
                request.setAttribute("message", "Payment success");
            }

        } else {
            request.setAttribute("message", "Payment failed");
        }

        request.getRequestDispatcher("Renter/PaymentResult.jsp").forward(request, response);
    }
    
    public List<Renter> getBasicRenterByEmaiAndPass(HttpServletRequest request) {
        HttpSession session = request.getSession();
        RenterDAO dao = new RenterDAO();
        List<Renter> basicDetailRenter = new ArrayList<>();
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        basicDetailRenter = dao.getRenterDetail(email, password);
        
        return basicDetailRenter;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "VNPay Return Controller";
    }
}
