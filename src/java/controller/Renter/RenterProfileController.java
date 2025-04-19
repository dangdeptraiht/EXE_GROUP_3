package controller.Renter;

import model.Account;
import model.UserDetail;
import dao.RenterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name="RenterProfileController", urlPatterns={"/renterprofile"})
public class RenterProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RenterProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RenterProfileController at " + request.getContextPath() + "</h1>");
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
        // Retrieve the session object
        HttpSession session = request.getSession();

        // Retrieve email and password from the session attributes
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        // Check if email and password are available in the session
        if (email != null && password != null) {
            // Use the email and password to fetch basic user details
            RenterDAO dao = new RenterDAO();
            UserDetail userDetail = dao.RenterBasicDetail(email, password);

            // Check if userDetail is not null
            if (userDetail != null) {
                // Set the userDetail object as a request attribute
                request.setAttribute("userDetail", userDetail);

                // Forward the request to the JSP page
                request.getRequestDispatcher("Renter/RenterProfile.jsp").forward(request, response);
            } else {
                // If no user detail is found, redirect to login page
                response.sendRedirect("login.jsp");
            }
        } else {
            // If email or password is not found in the session, redirect the user to the login page
            response.sendRedirect("login.jsp");
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
        // Retrieve the session object
        HttpSession session = request.getSession();

        // Retrieve email and password from the session attributes
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        // Check if email and password are available in the session
        if (email != null && password != null) {
            // Use the email and password to fetch basic user details
            RenterDAO dao = new RenterDAO();
            UserDetail userDetail = dao.RenterBasicDetail(email, password);

            // Check if userDetail is not null
            if (userDetail != null) {
                // Set the userDetail object as a request attribute
                request.setAttribute("userDetail", userDetail);

                // Forward the request to the JSP page
                request.getRequestDispatcher("Renter/RenterProfile.jsp").forward(request, response);
            } else {
                // If no user detail is found, redirect to login page
                response.sendRedirect("login.jsp");
            }
        } else {
            // If email or password is not found in the session, redirect the user to the login page
            response.sendRedirect("login.jsp");
        }
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
