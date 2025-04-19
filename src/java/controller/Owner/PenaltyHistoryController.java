/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import com.google.gson.Gson;
import dao.PenaltyDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Penalty;

/**
 *
 * @author DAT
 */
@WebServlet(name = "PenaltyHistoryController", urlPatterns = {"/penaltyHistory"})
public class PenaltyHistoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PenaltyDao dbPenalty = new PenaltyDao();
        ArrayList<Penalty> penaltys = dbPenalty.findAll();

        req.setAttribute("penaltys", penaltys);

        Gson gson = new Gson();
        String jsonData = gson.toJson(penaltys);

        req.setAttribute("dataList", jsonData);
        req.getRequestDispatcher("Owner/penaltys-history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
