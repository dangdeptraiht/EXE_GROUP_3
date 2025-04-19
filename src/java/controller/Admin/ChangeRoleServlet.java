/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dao.DAO;
import dao.DBContext;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
@WebServlet(name = "ChangeRoleServlet", urlPatterns = {"/changeRole"})
public class ChangeRoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeRoleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeRoleServlet at " + request.getContextPath() + "</h1>");
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
   String userEmail = request.getParameter("email");
        DAO dao = new DAO();
        if (userEmail != null && !userEmail.isEmpty()) {
            dao.updateUserRole(userEmail, 0);
        }
        response.sendRedirect("manage");
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
//        String email = request.getParameter("email");
//
//        try {
//            DAO userDao = new DAO();
//
//            if (userDao.isEmailExist(email)) {
//                int currentRole = userDao.getUserRole(email);
//
//                if (currentRole != 4 && currentRole != 0) {
//                    boolean success = userDao.updateUserRole(email, 0);
//                    if (success) {
//                        response.sendRedirect(request.getContextPath() + "/manageAccounts.jsp");
//                        return; // Kết thúc xử lý
//                    } else {
//                        response.getWriter().write("Failed to change user role: No rows updated");
//                    }
//                } else {
//                    response.getWriter().write("User role is 4 or already 0");
//                }
//            } else {
//                response.getWriter().write("Email does not exist");
//            }
//        } catch(IOException e){
//            
//        }
      
 }
    
   
    

    private boolean updateUserRole(String email) {
        // Thực hiện cập nhật role trong cơ sở dữ liệu
        // Giả sử chúng ta có một lớp DAO để tương tác với cơ sở dữ liệu
        DAO userDao = new DAO();
        int currentRole = userDao.getUserRole(email);

        if (currentRole != 4 && currentRole != 0) {
            return userDao.updateUserRole(email, 0);
        }

        return false;
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
