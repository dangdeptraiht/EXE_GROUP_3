/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Renter;

import dao.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.ReqType;
import model.RequestList;

/**
 *
 * @author quanb
 */
@WebServlet(name="ListRequestController", urlPatterns={"/listrequest1"})
public class ListRequestController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private RequestDAO requestDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        requestDAO = new RequestDAO();
    }

    private void populateRequestAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Account account = (Account) session.getAttribute("user");

        if (account != null) {
            int userID = account.getUserID();
            List<ReqType> requestTypes = requestDAO.getAllReqType();
            List<RequestList> requests = requestDAO.getReqListByID(userID);
            request.setAttribute("requestTypes", requestTypes);
            request.setAttribute("requests", requests);
            //Change date format
            String date_raw = null, date_convert = null;
            Date date = null;
            for (RequestList dateformat : requests) {
                date_raw = dateformat.getCreateAt();
                try {
                    date = inputFormat.parse(date_raw);
                } catch (ParseException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
                date_convert = outputFormat.format(date);
                dateformat.setCreateAt(date_convert);
            }

        } else {
            request.setAttribute("message", "User not logged in.");
        }
    }

    private void updateAbandonedRequests() {
        requestDAO.updateAbandonedRequests();
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
        updateAbandonedRequests();
        populateRequestAttributes(request);
        request.getRequestDispatcher("Renter/ListRequest.jsp").forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        
//    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
