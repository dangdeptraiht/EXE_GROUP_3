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
@WebServlet(name = "UpdateGuideLineController", urlPatterns = {"/updateGuideline"})
public class UpdateGuideLineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        GuideLineDAO dbGuideLine = new GuideLineDAO();
        Guideline guideLine = dbGuideLine.findById(id);

        req.setAttribute("guideline", guideLine);
        req.getRequestDispatcher("Owner/update-guideline.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        GuideLineDAO dbGuideLine = new GuideLineDAO();
        Guideline guideLine = dbGuideLine.findById(id);
        String guideName = req.getParameter("guideName");
        String imgGuide = req.getParameter("imgGuide");

        guideLine.setGuideName(guideName);
        guideLine.setImg(imgGuide);
        dbGuideLine.update(guideLine);
        resp.sendRedirect("guidelines");
    }

}
