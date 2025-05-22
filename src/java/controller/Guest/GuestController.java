/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Guest;

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
import model.UserDetail;

/**
 *
 * @author quocp
 */
@WebServlet(name = "GuestController", urlPatterns = {"/GuestController"})
public class GuestController extends HttpServlet {

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
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (email == null) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "GuestHome";
            }
            
            if (service.equals("GuestHome")) {
                GuestHome(request, response);
            } else if (service.equals("ListRoom")) {
                listRoom(request, response);
            } else if (service.equals("roomDetail")) {
                roomDetail(request, response);
            } else if (service.equals("rentRoom")) {
                request.setAttribute("error", "You have to login first!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    private void GuestHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        SliderDAO daol = new SliderDAO();
        List<Rooms> listRoomVip1 = dao.pagingRoomVip(1, 0, 1);
        List<Rooms> listRoomVip2 = dao.pagingRoomVip(1, 0, 2);
        List<Rooms> listRoomVip3 = dao.pagingRoomVip(1, 0, 3);
        List<Slider> sliders = daol.getAllSlider();
        request.setAttribute("listRoomVip1", listRoomVip1);
        request.setAttribute("listRoomVip2", listRoomVip2);
        request.setAttribute("listRoomVip3", listRoomVip3);
        request.setAttribute("slider", sliders);
        request.getRequestDispatcher("Guest/GuestHome.jsp").forward(request, response);
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO roomDAO = new RoomDAO();

        int index = Integer.parseInt(request.getParameter("index"));
        if (index == 0) {
            index = 1;
        }
        List<Rooms> rooms = roomDAO.pagingRoom(index, 0);
        List<Rooms> allRooms = roomDAO.getRooms();
        int totalRoom = roomDAO.getTotalRoom();
        int totalPage = totalRoom / 6;
        if (totalPage % 6 != 0) {
            totalPage++;
        }

        request.setAttribute("totalPage", totalPage);
        request.setAttribute("index", index);
        request.setAttribute("rooms", rooms);
        request.setAttribute("allRooms", allRooms);

        request.getRequestDispatcher("Guest/ListRoom.jsp").forward(request, response);
    }

    private void roomDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();

        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        request.setAttribute("roomDetail", roomDetail);
        request.getRequestDispatcher("Guest/RoomDetail.jsp").forward(request, response);
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
