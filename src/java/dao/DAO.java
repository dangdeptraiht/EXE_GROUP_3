/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author pc
 */
public class DAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        try {
            // Truy vấn dữ liệu từ bảng Accounts
            String query = "SELECT *  FROM [HL_Motel].[dbo].[account]";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("userID");
                String mail = resultSet.getString("userMail");
                String password = resultSet.getString("userPassword");
                int role = resultSet.getInt("userRole");

                // Tạo đối tượng Account và thêm vào danh sách
                Account acc = new Account(ID, mail, password, role);
                accounts.add(acc);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return accounts;
    }

    public int insertAcc(String mail, String password, int role) {
        int n = 0;
        String query = "INSERT INTO [dbo].[account]\n"
                + "           ([userMail]\n"
                + "           ,[userPassword]\n"
                + "           ,[userRole])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, mail);
            ps.setString(2, password);
            ps.setInt(3, role);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n;
    }

    public void editAccount(String mail, String password, String Role) {
        String query = "UPDATE [dbo].[account]\n"
                + "   \n"
                + "   SET [userPassword] = ?\n"
                + "      ,[userRole] = ?\n"
                + " WHERE [userMail] = ?";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, Role);
            ps.setString(3, mail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //check mail
    public boolean isEmailExist(String email) {
        String query = "SELECT COUNT(*) AS count FROM [HL_Motel].[dbo].[account] WHERE userMail = ?";
        boolean emailExists = false;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    emailExists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emailExists;
    }

    public int getUserRole(String email) {
        try {
            String query = "SELECT [userRole]\n"
                    + "  FROM [dbo].[account] WHERE [userMail] = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("userRole");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateUserRole(String email, int newRole) {
        try {
            String query = "UPDATE [dbo].[account]\n"
                    + " SET [userRole] = ? \n"
                    + " WHERE [userMail] = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, newRole);
            statement.setString(2, email);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
  

    public static void main(String args[]) {
       
        
                
    }
}
