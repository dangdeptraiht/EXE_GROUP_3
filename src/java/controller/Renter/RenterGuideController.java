
package controller.Renter;

import controller.Owner.*;
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

@WebServlet(name = "RenterGuideController", urlPatterns = {"/renterguideline"})
public class RenterGuideController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GuideLineDAO dbGuideline = new GuideLineDAO();
        ArrayList<Guideline> guideLines = dbGuideline.findAll();
        
        req.setAttribute("guidelines", guideLines);
        
        req.getRequestDispatcher("Renter/guidelinelist.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}