/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import dao.PenaltyDao;
import dao.RoomDAO;
import dao.RuleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Penalty;
import model.Room;
import model.Rooms;
import model.Rule;

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdatePenaltyControlller", urlPatterns = {"/updatePenalty"})
public class UpdatePenaltyControlller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        PenaltyDao dbPenalty = new PenaltyDao();
        Penalty penalty = dbPenalty.findById(id);
        RuleDAO dbRule = new RuleDAO();
        RoomDAO dbRoom = new RoomDAO();

        ArrayList<Rule> rules = dbRule.findAll();
        List<Rooms> rooms = dbRoom.getRooms();

        req.setAttribute("rules", rules);
        req.setAttribute("rooms", rooms);
        req.setAttribute("penalty", penalty);
        req.getRequestDispatcher("Owner/update-penalty.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        PenaltyDao dbPenalty = new PenaltyDao();
        Penalty penalty = dbPenalty.findById(id);

        String raw_roomId = req.getParameter("roomId");
        int roomId = Integer.parseInt(raw_roomId);
        String description = req.getParameter("description");
        String raw_date = req.getParameter("date");
        String status = req.getParameter("status");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(raw_date, formatter);
        java.sql.Date sqlDate = java.sql.Date.valueOf(raw_date);
        String raw_ruleId = req.getParameter("ruleId");
        int ruleId = Integer.parseInt(raw_ruleId);
        int statusId = Integer.valueOf(status);
        String evidenceImg = req.getParameter("evidenceImg");

        Room room = new Room();
        room.setRoomID(roomId);
        penalty.setRoomID(room);

        penalty.setDescription(description);
        penalty.setPenDate(sqlDate);
        penalty.setPenStatus(statusId);
        Rule rule = new Rule();
        rule.setRuleID(ruleId);
        penalty.setRuleID(rule);
        penalty.setEvidenceImg(evidenceImg);

        dbPenalty.update(penalty);
        resp.sendRedirect("penaltys");
    }

}
