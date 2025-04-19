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
import java.util.Date;
import java.util.List;
import model.User;
import model.UserDetail;

/**
 *
 * @author pc
 */
public class DAOUser extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<User> getUsers() {
        List<User> user = new ArrayList<>();

        try {
            // Truy vấn dữ liệu từ bảng Accounts
            String query = "SELECT * FROM [HL_Motel].[dbo].[user]";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String userGender = rs.getString("userGender");
                String userBirth = rs.getString("userBirth");
                String userAddress = rs.getString("userAddress");
                String userPhone = rs.getString("userPhone");
                String userAvatar = rs.getString("userAvatar");

                User users = new User(userID, userName, userGender, userBirth, userAddress, userPhone, userAvatar);
                user.add(users);
            }

            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return user;
    }

    public UserDetail getUsersByUserID(int userID) {
        UserDetail userDetail = null;
        try {
            // Truy vấn dữ liệu từ bảng Accounts
            String query = "  select u.userName, u.userGender, u.userBirth, u.userAddress, u.userPhone, a.userMail, u.userAvatar\n"
                    + "  from [user] u \n"
                    + "  join account a\n"
                    + "  on u.userID = a.userID\n"
                    + "  where u.userID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String userName = rs.getString("userName");
                String userGender = rs.getString("userGender");
                String userBirth = rs.getString("userBirth");
                String userAddress = rs.getString("userAddress");
                String userPhone = rs.getString("userPhone");
                String userMail = rs.getString("userMail");
                String userAvatar = rs.getString("userAvatar");

                userDetail = new UserDetail(userName, userGender, userBirth, userAddress, userPhone, userMail, userAvatar);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return userDetail;
    }

    public void insertUser( String name, String gender, String Dob, String address, String Phone, String avatar) {
        String query = "INSERT INTO [dbo].[user]\n"
                + "           ([userName]\n"
                + "           ,[userGender]\n"
                + "           ,[userBirth]\n"
                + "           ,[userAddress]\n"
                + "           ,[userPhone]\n"
                + "           ,[userAvatar]\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, Dob);
            ps.setString(4, address);
            ps.setString(5, Phone);
            ps.setString(6, avatar);

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        System.out.println("Inserted user with ID: " + userId);
                        // Thực hiện các hành động khác với userId (nếu cần)
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public void updateUser(int userId, String userName, String gender, String dob, String address, String phone, String avatar) {
        String query = "UPDATE [dbo].[user] "
                + "SET [userName] = ?, "
                + "    [userGender] = ?, "
                + "    [userBirth] = ?, "
                + "    [userAddress] = ?, "
                + "    [userPhone] = ? "
                + "    [userAvatar] = ? "
                + "WHERE [userID] = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, userName);
            ps.setString(2, gender);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, avatar);
            ps.setInt(7, userId);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int updateAvatarUser(int userID, String avatar) {
        String query = "UPDATE [dbo].[user]\n"
                + "   SET [userAvatar] = ?\n"
                + " WHERE userID = ?";
        
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, avatar);
            ps.setInt(2, userID);            

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String args[]) {
        DAOUser dao = new DAOUser();
        UserDetail basic = dao.getUsersByUserID(2);
        System.out.println(basic.getUserID());
    }
}
