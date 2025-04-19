/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Renter;

import dao.NewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.News;

@WebServlet(name = "ListNewController", urlPatterns = {"/news"})
public class ListNewController extends HttpServlet {

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
        NewDAO newsDAO = new NewDAO(); // Assuming NewsDAO handles database operations
//        List<News> ListN = newsDAO.getNewsList(); // Fetch news list from DAO
        String indexParam = request.getParameter("index");
        int index = 1;
        try {
            if (indexParam != null && !indexParam.isEmpty()) {
                index = Integer.parseInt(indexParam);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Get the page size from the request, defaulting to 5 if not provided or invalid
        String pageSizeParam = request.getParameter("pageSize");
        int pageSize = 5;
        try {
            if (pageSizeParam != null && !pageSizeParam.isEmpty()) {
                pageSize = Integer.parseInt(pageSizeParam);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // Get paginated products
        List<News> ListN = newsDAO.getNewsList(index, pageSize);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.S");
        SimpleDateFormat sds = new SimpleDateFormat("dd-MM-yyyy ");
        for (News news : ListN) {
            Date date = null;
            String formattedDate = news.getCreateAt();

            try {
                // Chuyển chuỗi gốc thành đối tượng Date
                date = inputFormat.parse(formattedDate);
                // Chuyển đối tượng Date thành chuỗi theo định dạng mong muốn
                formattedDate = sds.format(date);
                news.setCreateAt(formattedDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("ListN", ListN); // Set newsList attribute for JSP

        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", index);
        request.getRequestDispatcher("Renter/NewsPRO.jsp").forward(request, response); // Forward to JSP for display
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
        String search = request.getParameter("search");
        NewDAO newsDAO = new NewDAO();

        String indexParam = request.getParameter("index");
        int index = 1;
        try {
            if (indexParam != null && !indexParam.isEmpty()) {
                index = Integer.parseInt(indexParam);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String pageSizeParam = request.getParameter("pageSize");
        int pageSize = 5;
        try {
            if (pageSizeParam != null && !pageSizeParam.isEmpty()) {
                pageSize = Integer.parseInt(pageSizeParam);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        List<News> ListN = newsDAO.searchByText(index, pageSize, search);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.S");
        SimpleDateFormat sds = new SimpleDateFormat("dd-MM-yyyy ");
        for (News news : ListN) {
            Date date = null;
            String formattedDate = news.getCreateAt();

            try {
                date = inputFormat.parse(formattedDate);
                formattedDate = sds.format(date);
                news.setCreateAt(formattedDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("ListN", ListN);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", index);
        request.setAttribute("search", search);
        request.getRequestDispatcher("Renter/NewsPRO.jsp").forward(request, response);
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
