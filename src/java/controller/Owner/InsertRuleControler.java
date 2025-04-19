/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import com.sun.net.httpserver.HttpServer;
import dao.GuideLineDAO;
import dao.RuleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Guideline;
import model.Rule;

/**
 *
 * @author DAT
 */
@WebServlet(name = "InsertRuleControler", urlPatterns = {"/insertRule"})
public class InsertRuleControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Owner/add-rule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ruleName = req.getParameter("ruleName");
        String img = req.getParameter("img");
        String score = req.getParameter("score");
        String penMoney = req.getParameter("penMoney");
        Rule rule = new Rule();
        rule.setRuleName(ruleName);
        rule.setImg(img);
        rule.setScoreChange(Integer.parseInt(score));
        rule.setPenMoney(Double.parseDouble(penMoney));
        RuleDAO dbRule = new RuleDAO();
        dbRule.create(rule);
        resp.sendRedirect("ruleList");
    }
}
