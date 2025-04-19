/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.SecurityList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import dao.DBContext;
import model.UserDetail;

/**
 *
 * @author Admin
 */
public class SecurityListDAO extends DBContext {

    public List<SecurityList> getSeList() {
        List<SecurityList> se = new ArrayList<>();
        String sql = "SELECT[seID]\n"
                + "      ,x.[userName]\n"
                + "	  ,x.userPhone\n"
                + "	  ,x.userAddress\n"
                + "      ,[xShift]\n"
                + "	  ,[seStatus]\n"
                + "      ,[Department]\n"
                + "  FROM [HL_Motel].[dbo].[security]\n"
                + "  join [user] x on x.userID = security.userID";

        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SecurityList room = new SecurityList();
                room.setSeID(rs.getInt("seID"));
                room.setUserName(rs.getString("userName"));
                room.setUserPhone(rs.getString("userPhone"));
                room.setUserAddress(rs.getString("userAddress"));
                room.setxShift(rs.getInt("xShift"));
                room.setSeStatus(rs.getBoolean("seStatus"));

                room.setDepartment(rs.getString("Department"));

                se.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return se;
    }

    public void updateShiftSe(String xShift,String Department, String seID) {
        String sql = "UPDATE [dbo].[security]\n"
                + "   SET [xShift] = ?\n"
                + "      ,[Department] = ?\n"
                + " WHERE seID = ?";
        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, xShift);
            ps.setString(2, Department);
            ps.setString(3, seID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public SecurityList selectUpdateByPenID(String seID) {
        String sql = "SELECT[seID]\n"
                + "      ,x.[userName]\n"
                + "	  ,x.userPhone\n"
                + "	  ,x.userAddress\n"
                + "      ,[xShift]\n"
                + "	  ,[seStatus]\n"
                + "      ,[Department]\n"
                + "  FROM [HL_Motel].[dbo].[security]\n"
                + "  join [user] x on x.userID = security.userID"
                + " WHERE seID = ?"
                ;
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, seID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SecurityList(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getString(7));
                        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public SecurityList SecurityBasicDetail(String accountInput, String passwordInput) {
        SecurityList selist = null;
        String sql = "SELECT  \n" +
"                 a.userID, u.userName, u.userAddress, u.userPhone,  \n" +
"                 a.userMail, a.userPassword,b.xShift, b.Department,b.seID\n" +
"                 FROM  \n" +
"                 [user] u  \n" +
"                 JOIN  \n" +
"                 account a ON u.userID = a.userID \n" +
"				 join [security] b on b.userID = u.userID \n" +
"                 WHERE  \n" +
"                 a.userMail = ?  AND a.userPassword = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, accountInput);
            ps.setString(2, passwordInput);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int userID = rs.getInt(1);
                    String userName = rs.getString(2);
                    String userAddress = rs.getString(3);
                    String userPhone = rs.getString(4);
                    String userMail = rs.getString(5);
                    String userPassword = rs.getString(6);
                    int xShift = rs.getInt(7);
                    String Department = rs.getString(8);
                    int seID = rs.getInt(9);

                    selist = new SecurityList(userID, userName,userAddress, userPhone, userMail, userPassword,xShift,Department,seID);
                }
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return selist;
    }
    
    public SecurityList showShift(int userID) {
        String sql = "SELECT[seID]\n"
                + "      ,x.[userName]\n"
                + "	  ,x.userPhone\n"
                + "	  ,x.userAddress\n"
                + "      ,[xShift]\n"
                + "	  ,[seStatus]\n"
                + "      ,[Department]\n"
                + "  FROM [HL_Motel].[dbo].[security]\n"
                + "  join [user] x on x.userID = security.userID"
                + " WHERE x.userID = ?"
                ;
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SecurityList(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getString(7));
                        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    
    public static void main(String[] args) {
        SecurityListDAO securityListDAO = new SecurityListDAO();     
        SecurityList security = securityListDAO.showShift(19);
        System.out.println(security);
        
    }
}
