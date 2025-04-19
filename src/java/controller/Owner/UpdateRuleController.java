/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

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
@WebServlet(name = "UpdateRuleController", urlPatterns = {"/updateRule"})
public class UpdateRuleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        RuleDAO dbRule = new RuleDAO();
        Rule rule = dbRule.findById(id);

        req.setAttribute("rule", rule);
        req.getRequestDispatcher("Owner/update-rule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        GuideLineDAO dbGuideLine = new GuideLineDAO();
        RuleDAO dbRule = new RuleDAO();
        Rule rule = dbRule.findById(id);
        String ruleName = req.getParameter("ruleName");
        String img = req.getParameter("img");
        String score = req.getParameter("score");
        String penMoney = req.getParameter("penMoney");

        rule.setRuleName(ruleName);
        rule.setImg(img);
        rule.setScoreChange(Integer.parseInt(score));
        rule.setPenMoney(Double.parseDouble(penMoney));
        dbRule.update(rule);
        resp.sendRedirect("ruleList");

    }

}
