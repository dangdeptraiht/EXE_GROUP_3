/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Owner;

import dao.BillDAO;
import dao.RoomDAO;
import model.Bill;
import model.Room;
import model.UsagePrice;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quocp
 */
@WebServlet(name = "EditRoomFeeController", urlPatterns = {"/EditRoomFeeController"})
public class EditRoomFeeController extends HttpServlet {

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
            out.println("<title>Servlet EditRoomFeeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditRoomFeeController at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        
        HttpSession session = request.getSession();
        BillDAO daoBill = new BillDAO();
        int id = 0;
        try {
            id = Integer.parseInt(id_raw);
            Bill bill = daoBill.getBillBybillID(id);

            
            session.setAttribute("billID", id);

            RoomDAO daoRoom = new RoomDAO();
            Room room = daoRoom.getRoomDetailByID(id);

            UsagePrice price = daoBill.getEWPrice();
            double eprice = price.getEprice();
            double wprice = price.getWprice();

            request.setAttribute("eprice", eprice);
            request.setAttribute("wprice", wprice);
            request.setAttribute("room", room);
            request.setAttribute("billDetail", bill);

        } catch (NumberFormatException e) {
            System.err.println("Fail:" + e);
        }
        request.getRequestDispatcher("Owner/editroomfee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getSession().getAttribute("billID").toString());
        double service = Double.parseDouble(request.getParameter("service"));
        double electric = Double.parseDouble(request.getParameter("electric"));
        double water = Double.parseDouble(request.getParameter("water"));
        BigDecimal roomFee = new BigDecimal(request.getParameter("roomFee"));
        double other = Double.parseDouble(request.getParameter("other"));
        double penMoney = Double.parseDouble(request.getParameter("penMoney"));
        String deadline = request.getParameter("deadline");
        String payAt = request.getParameter("payAt");
        HttpSession session = request.getSession();
        int roomID = (int)  session.getAttribute("roomID");

        BillDAO billDAO = new BillDAO();

        boolean success = billDAO.updateFeeById(id, service, electric, water, roomFee, other, penMoney, deadline, payAt);

        String updateMessage = success ? "Update Successful" : "Update Failed";
        request.setAttribute("updateMessage", updateMessage);
        request.getRequestDispatcher("/Owner/editroomfee.jsp?id=" + roomID).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
