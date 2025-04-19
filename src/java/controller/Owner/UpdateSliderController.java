/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Owner;

import dao.SliderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import model.Slider;

/**
 *
 * @author quanb
 */
@WebServlet(name = "UpdateSliderController", urlPatterns = {"/UpdateSliderController"})
@MultipartConfig
public class UpdateSliderController extends HttpServlet {

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
            out.println("<title>Servlet UpdateSliderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateSliderController at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");

        if (id_raw == null || id_raw.isEmpty()) {
            // Nếu ID là null hoặc rỗng, trả về lỗi
            request.setAttribute("error", "ID is required and cannot be empty");
            request.getRequestDispatcher("Owner/EditNews.jsp").forward(request, response);
            return;
        }

        int id = 0;
        try {
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid ID format: " + id_raw);
            request.getRequestDispatcher("Owner/EditNews.jsp").forward(request, response);
            return;
        }
        String name = request.getParameter("name");
        Part imagePart = request.getPart("img");
        String date = request.getParameter("date");
        if (name == null || name.isEmpty() || imagePart == null || date == null || date.isEmpty()) {
            request.setAttribute("error", "All field are required");
            request.getRequestDispatcher("Owner/EditSlider.jsp").forward(request, response);
            return;
        }
        byte[] photo = convertInputStreamToByteArray(imagePart.getInputStream());
        String imgBase64 = Base64.getEncoder().encodeToString(photo);

        SliderDAO dao = new SliderDAO();
        Slider slider = new Slider(name, imgBase64, date);
        slider.setSliderId(id);
        int result = dao.updateSlider(slider);
        if (result > 0) {
            response.sendRedirect("displayslider");
        } else {
            request.setAttribute("errorMessage", "Error updating slider");
            request.getRequestDispatcher("Owner/EditSlider.jsp").forward(request, response);
        }

    }

    private byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
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
