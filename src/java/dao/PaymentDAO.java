/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import model.Guideline;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payment;

/**
 *
 * @author DAT
 */
public class PaymentDAO extends DBContext {

    public void deleteMoney(int renterID) {
        int n = 0;
        String sql = "DELETE FROM payments\n"
                + " WHERE userid = ?;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, renterID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Payment> findAll() {
        ArrayList<Payment> payments = new ArrayList<>();
        try {
            String sql = "select * from payments";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                payments.add(toPayment(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payments;
    }

    public ArrayList<Payment> findByUserId(int userId) {
        ArrayList<Payment> payments = new ArrayList<>();
        try {
            String sql = "select * from payments where userId = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                payments.add(toPayment(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payments;
    }

    public int insert(Payment model) {
        try {
            String sql = "insert into payments([money], userId, status, createdAt, updatedAt) values (?,?,?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, model.getMoney());
            ps.setInt(2, model.getUserId());
            ps.setInt(3, model.getStatus());
            java.util.Date utilTodayDate = Calendar.getInstance().getTime();

            java.sql.Date sqlTodayDate = new java.sql.Date(utilTodayDate.getTime());

            ps.setDate(4, sqlTodayDate);
            ps.setDate(5, sqlTodayDate);
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    private Payment toPayment(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getInt("id"));
        payment.setUserId(rs.getInt("userId"));
        payment.setMoney(rs.getDouble("money"));
        payment.setStatus(rs.getInt("status"));
        payment.setCreatedAt(rs.getDate("createdAt"));
        payment.setUpdatedAt(rs.getDate("updatedAt"));
        return payment;
    }

    public int addMoney(double money, int renterID) {
        int n = 0;
        String sql = "UPDATE [dbo].[renter]\n"
                + "   SET [balance] += ?\n"
                + " WHERE renterID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setDouble(1, money);
            pre.setInt(2, renterID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }
        return n;
    }

    public int updatePaymentStatus(int id) {
        int n = 0;
        String sql = "UPDATE [dbo].[payments] set [status] = 1 where id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }
        return n;
    }

    public int displayMoney(int renterID) {
        int balance = 0;
        String sql = "  select balance from renter where renterID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, renterID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                balance = rs.getInt("balance");
            }

        } catch (SQLException ex) {

        }
        return balance;
    }

    public static void main(String[] args) {
        PaymentDAO dao = new PaymentDAO();
        int displayMoney = dao.displayMoney(602);
        System.out.println(displayMoney);

    }

    public int updateRenterMoney(int renterID, double balance) {
        int n = 0;
        String sql = "UPDATE [dbo].[renter] set [balance] = ? where renterID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setDouble(1, balance);
            pre.setInt(2, renterID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }
        return n;
    }
}
