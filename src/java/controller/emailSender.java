package controller;

import dao.RegisterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;
import model.Account;
import model.User;

@WebServlet(name = "emailSender", urlPatterns = {"/emailSender"})
public class emailSender extends HttpServlet {

    private static final String PHONE_NUMBER_REGEX = "^0\\d{9}$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RegisterDAO dao = new RegisterDAO();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        List<Account> listAccount = dao.getListAccount();

        // phone_regex
        Pattern phone_number_pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = phone_number_pattern.matcher(phone);
        if (!matcher.matches()) {
            request.setAttribute("error", "Invalid phone number!!!");
            request.getRequestDispatcher("register.jsp").forward(request, response);            
        }

        // check exist email
        for (Account account : listAccount) {
            if (email.equals(account.getUserMail())) {
                request.setAttribute("error", "Email already exists!!!");
                request.getRequestDispatcher("register.jsp").forward(request, response);              
            }
        }

        // random otp
        String code = generateRandomCode();
        // send email
        boolean emailSent = sendEmail(email, code);

        if (emailSent) {
            // Save the confirmation code and send to session
            HttpSession session = request.getSession();
            session.setAttribute("authCode", code);
            session.setAttribute("codeGeneratedTime", System.currentTimeMillis());

            session.setAttribute("email", email);
            session.setAttribute("phone", phone);
            session.setAttribute("username", username);
            session.setAttribute("gender", gender);
            session.setAttribute("dob", dob);
            session.setAttribute("password", password);
            session.setAttribute("address", address);

            // sendRedirect verify page
            request.getRequestDispatcher("verifyCode.jsp").forward(request, response);
        } else {
            response.getWriter().println("Sending email failed. Please try again.");
        }

    }

    private boolean sendEmail(String recipient, String code) throws UnsupportedEncodingException {
        // email account information
        String email = "cuongntthe173555@fpt.edu.vn";
        String appPassword = "mids kchv fitq nsjo";
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587;

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, appPassword);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email, "Admin"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Verification");
            message.setText("Your verification code is: " + code);

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace(); // Log error details to the console
            log("Error sending email: " + e.getMessage(), e); // Write errors to the servlet log
            return false;
        }
    }

    private String generateRandomCode() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        while (code.length() < 6) {
            int index = rnd.nextInt(chars.length());
            code.append(chars.charAt(index));
        }
        return code.toString();
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
