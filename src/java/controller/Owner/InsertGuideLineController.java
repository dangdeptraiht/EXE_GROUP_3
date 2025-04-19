/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import dao.GuideLineDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Guideline;

/**
 *
 * @author DAT
 */
@WebServlet(name = "InsertGuideLineController", urlPatterns = {"/addGuideline"})
public class InsertGuideLineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Owner/add-guideline.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String guideName = req.getParameter("guideName");
        String imgGuide = req.getParameter("imgGuide");
        GuideLineDAO dbGuideline = new GuideLineDAO();
        dbGuideline.insert(new Guideline(guideName, imgGuide));
        resp.sendRedirect("guidelines");
    }

}
