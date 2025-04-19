
package controller.Renter;

import dao.PaymentDAO;
import dao.RenterDAO;
import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Renter;

@WebServlet(name = "CancleRoom", urlPatterns = {"/CancleRoom"})
public class CancleRoom extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        RoomDAO dao = new RoomDAO();
        RenterDAO renterDAO = new RenterDAO();
        PaymentDAO pdao = new PaymentDAO();
        //get email and password 
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        int renterID = 0;
        int userID = 0;
        List<Renter> getBasicRenter = (List<Renter>) renterDAO.getRenterDetail(email, password);
        for (Renter renter : getBasicRenter) {
            renterID = renter.getRenterID();
            userID = renter.getUserID();
        }

        int roomID = Integer.parseInt(request.getParameter("roomId"));

        int cancleRoom = dao.cancleRoom(renterID, roomID);

        if (cancleRoom > 0) {
            request.setAttribute("Successfully canceled the room", "message");
            pdao.deleteMoney(userID);
            request.getRequestDispatcher("Renter/RenterRoomDetail.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
