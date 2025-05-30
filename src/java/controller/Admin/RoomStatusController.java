/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dao.DAOUser;
import dao.RoomDAO;
import dao.SliderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.RoomDetailSe;
import model.Rooms;
import model.Slider;
import model.User;
import model.UserDetail;

/**
 *
 * @author quocp
 */
@WebServlet(name = "RoomStatusController", urlPatterns = {"/rooms"})
public class RoomStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RoomDAO roomDAO = new RoomDAO();
        List<Rooms> rooms = roomDAO.getRooms();
        
        request.setAttribute("rooms", rooms);
        
        request.getRequestDispatcher("Admin/Rooms.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomDAO roomDAO = new RoomDAO();
        
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        int newStatus = Integer.parseInt(request.getParameter("roomStatus"));
        
        roomDAO.updateRoomStatus(roomID, newStatus);
        
        List<Rooms> rooms = roomDAO.getRooms();
        
        request.setAttribute("rooms", rooms);
        
        request.getRequestDispatcher("Admin/Rooms.jsp").forward(request, response);
    }
}
