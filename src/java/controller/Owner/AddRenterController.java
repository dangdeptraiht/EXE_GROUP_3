/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Owner;

import dao.RenterDAO;
import dao.RoomDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Room;
import model.Rooms;
import model.User;

/**
 *
 * @author quocp
 */
@WebServlet(name="AddRenterController", urlPatterns={"/AddRenterController"})
public class AddRenterController extends HttpServlet {
   
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
        UserDAO userDAO = new UserDAO();
        RoomDAO roomDAO = new RoomDAO();
        
        
        List<Rooms> listRoomAvailable = roomDAO.getRoomsAvailable();
        List<User> listUserAvailable = userDAO.getUserAvailable();
        
        request.setAttribute("listRoomAvailable", listRoomAvailable);
        request.setAttribute("listUserAvailable", listUserAvailable);
        request.getRequestDispatcher("Owner/addRenter.jsp").forward(request, response);
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
        RenterDAO renterDAO = new RenterDAO();
        RoomDAO roomDAO = new RoomDAO();
        
        int roomID = Integer.parseInt(request.getParameter("roomID"));        
        int userID = Integer.parseInt(request.getParameter("userID")); 
        Room getRoomDetailByID = roomDAO.getRoomDetailByID(roomID);
        
        int addRenter = renterDAO.addRenter(userID, roomID);
        boolean rentRoom = renterDAO.rentRoom(roomID);
        
        if (getRoomDetailByID.getRoomSize() == 1) {
            roomDAO.updateRoomStatus(roomID, 0);
            roomDAO.updateRoomOccupant(roomID);
        } else if (getRoomDetailByID.getRoomSize() == 2) {
            if (getRoomDetailByID.getRoomOccupant() == 0) {
                
                roomDAO.updateRoomStatus(roomID, 1);
            } else if (getRoomDetailByID.getRoomOccupant() == 1) {
                
                roomDAO.updateRoomStatus(roomID, 0);
            }
        }
        
        if (addRenter > 0 && rentRoom) {
            request.setAttribute("Add renter successfully!!", "message");
        } else {
            request.setAttribute("Add renter failed!!", "message");
        }
        
        request.getRequestDispatcher("ListRenterController").forward(request, response);
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
