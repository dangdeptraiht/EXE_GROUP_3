package controller.Renter;

import dao.RenterDAO;
import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import model.User;
import model.UserDetail;

@WebServlet(name = "UpdateProfileRenterController", urlPatterns = {"/UpdateProfileRenterController"})
@MultipartConfig
public class UpdateProfileRenterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String service = request.getParameter("service");
        if (service.equals("formRenterUpdateProfile")) {
            formRenterUpdateProfile(request, response);
        } else if (service.equals("updateProfileRenter")) {
            updateProfileRenter(request, response);
        } else if (service.equals("updateRenterAvatar")) {
            updateAvatar(request, response);
        }
    }
    
    private void formRenterUpdateProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            int userID = userDetail.getUserID();

            // Check if userDetail is not null
            if (userDetail != null) {
                // Set the userDetail object as a request attribute
                request.setAttribute("userDetail", userDetail);
                session.setAttribute("userID", userID);

                // Forward the request to the JSP page
                request.getRequestDispatcher("Renter/RenterUpdateProfile.jsp").forward(request, response);
            } else {
                // If no user detail is found, redirect to login page
                response.sendRedirect("login.jsp");
            }
        } else {
            // If email or password is not found in the session, redirect the user to the login page
            response.sendRedirect("login.jsp");
        }
    }
    
    private void updateProfileRenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RenterDAO dao = new RenterDAO();
        HttpSession session = request.getSession();
        
        int userID = (int) session.getAttribute("userID");
        
        boolean hasError = false;
        String fullName = request.getParameter("fullName").trim();
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        if (fullName == null || fullName.isEmpty() || fullName.isBlank() || fullName.trim().isEmpty()) {
            hasError = true;
        } else if (phone == null || phone.length() != 10 || !phone.startsWith("0") || !phone.matches("[0-9]+")) {
            hasError = true;
        } else if (address == null || address.isEmpty() || address.isBlank()) {
            hasError = true;
        }
        
        if (hasError) {
            request.setAttribute("error", "Invalid input information. Please check again.");
            request.getRequestDispatcher("renterprofile").forward(request, response);
        } else {
            boolean updateRenterProfile = dao.updateUser(userID, gender, address, phone, dob, fullName);
            
            request.getRequestDispatcher("renterprofile").forward(request, response);
        }
    }
    
    private void updateAvatar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RenterDAO dao = new RenterDAO();
        HttpSession session = request.getSession();
        
        int userID = (int) session.getAttribute("userID");
        session.getAttribute("");
        // lưu ảnh base64
        
        Part photo = request.getPart("img");
        byte[] avatar_raw = convertInputStreamToByteArray(photo.getInputStream());
        String avatar = Base64.getEncoder().encodeToString(avatar_raw);
        int updateAvatar = dao.updateAvatar(new User(userID, avatar));
        
        User user = dao.getUserByID(userID);
        String imgAvata = user.getUserAvatar();
        session.removeAttribute(imgAvata);
        session.setAttribute("imgAvata", imgAvata);
        request.getRequestDispatcher("renterprofile").forward(request, response);
    }
    
    public byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];        
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
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
