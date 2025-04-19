/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Renter;

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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.RoomDetailSe;
import model.Rooms;
import model.UserDetail;

@WebServlet(name = "RenterListRoom", urlPatterns = {"/RenterRoomController"})
public class RenterRoomController extends HttpServlet {

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

        String service = request.getParameter("service");

        if (service.equals("listRoom")) {
            listRoom(request, response);
        } else if (service.equals("roomDetail")) {
            roomDetail(request, response);
        } else if (service.equals("rentRoom")) {
            rentRoom(request, response, 0);
        } else if (service.equals("cancelRoom")) {
            rentRoom(request, response, 1);
        } else if (service.equals("confirmRentRoom")) {
            confirmRentRoom(request, response);
        }
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO roomDAO = new RoomDAO();
        UserDAO userDAO = new UserDAO();
        RenterDAO renterDAO = new RenterDAO();
        HttpSession session = request.getSession();
        
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        UserDetail userDetail = renterDAO.RenterBasicDetail(email, password);
        int userID = userDetail.getUserID();
        int isRenter = userDAO.isRenter(userID);
        int index = Integer.parseInt(request.getParameter("index"));
        if (index == 0) {
            index = 1;
        }
        List<Rooms> rooms = roomDAO.pagingRoom(index, 0);
        List<Rooms> allRooms = roomDAO.getRooms();
        int totalRoom = roomDAO.getTotalRoom();
        int totalPage = totalRoom / 6;
        if (totalRoom % 6 != 0) {
            totalPage++;
        }
        
        request.setAttribute("isRenter", isRenter);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("index", index);
        request.setAttribute("rooms", rooms);
        request.setAttribute("allRooms", allRooms);

        request.getRequestDispatcher("Renter/listRoom.jsp").forward(request, response);
    }

    private void roomDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        HttpSession session = request.getSession();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        request.setAttribute("roomDetail", roomDetail);
        session.setAttribute("roomID", roomID);
        request.getRequestDispatcher("Renter/roomDetail.jsp").forward(request, response);
    }

    private void rentRoom(HttpServletRequest request, HttpServletResponse response, int flag) throws ServletException, IOException {
        RenterDAO daoRenter = new RenterDAO();
        RoomDAO daoRoom = new RoomDAO();
        HttpSession session = request.getSession();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        if (flag == 0) {
            boolean lockRoom = daoRenter.lockRoom(roomID);
            RoomDetailSe roomDetail = daoRoom.getRoomDetail(roomID);
            UserDetail basicUserDetail = daoRenter.RenterBasicDetail(email, password);
            int userID = basicUserDetail.getUserID();
            request.setAttribute("userID", userID);
            request.setAttribute("roomDetail", roomDetail);
            request.getRequestDispatcher("Renter/confirmRentRoom.jsp").forward(request, response);
        } else if (flag == 1) {
            boolean unlockRoom = daoRenter.unlockRoom(roomID);
            request.getRequestDispatcher("RenterRoomController?service=listRoom&index=1").forward(request, response);
        }
    }

    private void confirmRentRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        HttpSession session = request.getSession();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        request.setAttribute("roomDetail", roomDetail);
        session.setAttribute("roomID", roomID);
        request.getRequestDispatcher("Renter/confirmRentRoom.jsp").forward(request, response);
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
