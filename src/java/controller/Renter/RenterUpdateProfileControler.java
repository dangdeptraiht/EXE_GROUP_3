/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Renter;

import model.User;
import dao.RenterDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class RenterUpdateProfileControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RenterHomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RenterHomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String jspuserID = request.getParameter("userID");
        int userId;
        RenterDAO dao = new RenterDAO();
        
        System.out.println("Received userID parameter: " + jspuserID);
        
        try {
            userId = Integer.parseInt(jspuserID);
            User u = dao.getUserByID(userId); // Hardcoded value '1' - consider using userId instead?
            request.setAttribute("user", u); // Set the user attribute to be passed to the JSP page  
            request.getRequestDispatcher("Renter/RenterUpdateProfile.jsp").forward(request, response); // Forward the request to the JSP page
            System.out.println("Forwarded request to RenterUpdateProfile.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Handle the exception properly
            System.err.println("NumberFormatException occurred: " + e.getMessage());
        }
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
    request.setCharacterEncoding("UTF-8");
    
    // Get userID from request parameter
    String jspuserID = request.getParameter("userID");
    
    // Initialize variables
    int userId;
    String name = request.getParameter("userName");
    String gender = request.getParameter("userGender");
    String birth = request.getParameter("userBirth");
    String address = request.getParameter("userAddress");
    String phone = request.getParameter("userPhone");
    String avatar = "./Image/user/avatar1.jpg";
    
    // Initialize DAO
    RenterDAO dao = new RenterDAO();
    
    try {
        // Parse userID to integer
        userId = Integer.parseInt(jspuserID);
        
        // Retrieve user from database
        User u = dao.getUserByID(userId);
        
        // Create a new user object with updated information
        User uNew = new User(userId, name, gender, birth, address, phone, avatar);
        
        // Update user in the database
        dao.updateUser(uNew);
        
        // Redirect to a confirmation page or back to the profile page
        response.sendRedirect("renterupdate?userID=" + userId);
    } catch (NumberFormatException e) {
        // Handle NumberFormatException
        e.printStackTrace();
        System.err.println("NumberFormatException occurred: " + e.getMessage());
        // Redirect to an error page or display an error message
        response.sendRedirect("error.jsp");
    } catch (Exception e) {
        // Handle other exceptions
        e.printStackTrace();
        System.err.println("Exception occurred: " + e.getMessage());
        // Redirect to an error page or display an error message
        response.sendRedirect("error.jsp");
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
