/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import com.google.gson.Gson;
import dao.GuideLineDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Guideline;

/**
 *
 * @author DAT
 */
@WebServlet(name = "GuildeLinesController", urlPatterns = {"/guidelines"})
public class GuildeLinesController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GuideLineDAO dbGuideline = new GuideLineDAO();
        ArrayList<Guideline> guideLines = dbGuideline.findAll();
        
        req.setAttribute("guidelines", guideLines);
          Gson gson = new Gson();
        String jsonData = gson.toJson(guideLines);
        
        req.setAttribute("dataList", jsonData);
        req.getRequestDispatcher("Owner/guidelines-list.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}