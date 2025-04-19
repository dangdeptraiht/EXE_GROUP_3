/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Admin;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 *
 * @author pc
 */
@WebServlet(name="Edit", urlPatterns={"/edac"})
public class Edit extends HttpServlet {
   
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
            out.println("<title>Servlet Edit</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Edit at " + request.getContextPath () + "</h1>");
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
        String spassword = request.getParameter("password");
        String srole = request.getParameter("role");
        String smail = request.getParameter("email");
        System.out.println("Email: " + smail);
        System.out.println("Password: " + spassword);
        System.out.println("Role: " + srole);
        response.setContentType("text/html;charset=UTF-8");
 response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            int role = Integer.parseInt(srole);
             if (role < 1 || role > 3) {
                throw new IllegalArgumentException("Role must be between 1 and 3.");
            }
            if (!isValidPassword(spassword)) {
                
                request.setAttribute("errorMessage", "Password must contain at least 8 characters, including uppercase letters and numbers.");
                request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
            } else {
              
                DAO dao = new DAO();
                dao.editAccount(smail, spassword, srole);

               
                response.sendRedirect("manage");
            }
        } catch (Exception e) {
           
            e.printStackTrace(); 
            request.setAttribute("errorMessage", "An error occurred while updating the account. Please try again.");
            request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
        }
          
     
        
    }
        private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {return true;
            }
        }
        return false;
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
