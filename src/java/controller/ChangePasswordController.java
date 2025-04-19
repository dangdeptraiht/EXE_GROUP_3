/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.*;

/**
 * @author DAT
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/changePassword"})
public class ChangePasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("user");
        if (account == null) {
            req.getRequestDispatcher("GuestController").forward(req, resp);
        } else {
            req.getRequestDispatcher("change-password.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) req.getSession().getAttribute("user");
        AccountDAO dbAccount = new AccountDAO();
        if (account == null) {
            req.getRequestDispatcher("GuestController").forward(req, resp);
        } else {
            System.out.println(account.getUserID());
            System.out.println(account.getUserMail());
            Account accountInDb = dbAccount.findByEmail(account.getUserMail());
            String oldPassword = req.getParameter("oldPassword");
            if (!oldPassword.equals(accountInDb.getUserPassword())) {
                req.setAttribute("message", "Your old password is wrong");
                req.getRequestDispatcher("change-password.jsp").forward(req, resp);
            } else {
                String password = req.getParameter("password");
                String rePassword = req.getParameter("rePassword");
                if (!password.matches("^(?=.*\\d)[A-Za-z\\d]{8,}$")) {
                    req.setAttribute("message", "Please just enter your password at least 8 characters and 1 numbers and do not have"
                            + " any special characters");
                    req.getRequestDispatcher("change-password.jsp").forward(req, resp);
                } else {
                if (!password.equals(rePassword)) {
                    req.setAttribute("message", "Your repeat password is wrong");
                    req.getRequestDispatcher("change-password.jsp").forward(req, resp);
                } else {
                    accountInDb.setUserPassword(password);
                    dbAccount.updatePassword(accountInDb);
                    session.invalidate();
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        }
    }
}
}