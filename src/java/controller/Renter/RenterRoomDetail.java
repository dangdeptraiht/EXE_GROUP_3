/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Renter;

import dao.BillDAO;
import dao.RenterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Bill;
import model.RentDetail;
import model.Renter;

@WebServlet(name="RenterRoomDetail", urlPatterns={"/RenterRoomDetail"})
public class RenterRoomDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RenterRoomDetail</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RenterRoomDetail at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          HttpSession session = request.getSession();
        RenterDAO dao = new RenterDAO();
        BillDAO billDAO = new BillDAO();

        // get notifi from paymentbillcontroller servlet
        Boolean paymentSuccess = (Boolean) request.getSession().getAttribute("paymentSuccess");
        if (paymentSuccess != null) {
            request.getSession().removeAttribute("paymentSuccess");
            request.setAttribute("paymentSuccess", paymentSuccess);
        }

        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        List<Renter> basicDetailRenter = dao.getRenterDetail(email, password);
        int userID = 0;
        for (Renter renter : basicDetailRenter) {
            userID = renter.getUserID();
        }

        // Call the rentDetail method
        List<RentDetail> rentDetails = dao.rentDetail(userID);

        //get roomID
        int roomID = 0;
        for (RentDetail rentDetail : rentDetails) {
            roomID = rentDetail.getRoomID();
        }

        //take all money of a person from roomID of that person's room
        Bill getBillByRoomID = billDAO.getBillDetailByRoomID(roomID);

        // Set the rent details and bill as a request attribute
        request.setAttribute("rentDetails", rentDetails);
        request.setAttribute("bill", getBillByRoomID);

        // Forward the request to the JSP page
        request.getRequestDispatcher("Renter/RenterRoomDetail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
