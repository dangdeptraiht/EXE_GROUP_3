/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import com.google.gson.Gson;
import dao.GuideLineDAO;
import dao.RuleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Guideline;
import model.Rule;

/**
 *
 * @author DAT
 */
@WebServlet(name = "RuleListController", urlPatterns = {"/ruleList"})
public class RuleListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RuleDAO dbRule = new RuleDAO();
        ArrayList<Rule> rules = dbRule.findAll();

        req.setAttribute("rules", rules);

        Gson gson = new Gson();
        String jsonData = gson.toJson(rules);

        req.setAttribute("dataList", jsonData);
        req.getRequestDispatcher("Owner/rules-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
