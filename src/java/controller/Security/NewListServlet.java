/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Security;

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

/**
 *
 * @author admin
 */
@WebServlet(name = "NewListServlet", urlPatterns = {"/newlist"})
public class NewListServlet extends HttpServlet {

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
        List<News> ListR = newsDAO.getNewsList(index, pageSize);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sds = new SimpleDateFormat("dd-MM-yyyy ");
        for (News news : ListR) {
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

        request.setAttribute("list", ListR);
        request.getRequestDispatcher("Security/newList.jsp").forward(request, response);
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
        String raw_search = request.getParameter("search");
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
        NewDAO newsDAO = new NewDAO();
        List<News> ListR = newsDAO.searchByText(index, pageSize, raw_search);
        System.out.println(ListR.size());
        request.setAttribute("list", ListR); // Set newsList attribute for JSP

        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", index);
        request.setAttribute("search", raw_search);
        request.getRequestDispatcher("Security/newList.jsp").forward(request, response);
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
