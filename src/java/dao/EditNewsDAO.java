/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import com.sun.jdi.connect.spi.*;

import java.sql.PreparedStatement;
import model.News;
import java.sql.ResultSet;

/**
 *
 * @author pc
 */
public class EditNewsDAO extends DBContext {

    public int updateNews(News news) {
        int n = 0;
        String query = "String query = \"UPDATE [dbo].[news]\\n\"\n"
                + "                 + \"SET [newTitle] = ?,\\n\"\n"
                + "                 + \"    [description] = ?,\\n\"\n"
                + "                 + \"    [img] = ?,\\n\"\n"
                + "                 + \"    [creatAt] = ?\\n\"\n"
                + "                 + \"WHERE [newID] = ?\";\n";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, news.getNewTitle());
            ps.setString(2, news.getDescription());
            ps.setString(3, news.getImg());
            ps.setString(4, news.getCreateAt());
            ps.setInt(5, news.getNewId());

            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public News getNewsById(int id) {
        News news = null;
        String query = "SELECT * FROM [dbo].[news] WHERE newID = ?";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                news = new News();
                news.setNewId(rs.getInt("newID"));
                news.setNewTitle(rs.getString("newTitle"));
                news.setDescription(rs.getString("description"));
                news.setImg(rs.getString("img"));
                news.setCreateAt(rs.getString("creatAt"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public int DeleteNews(News news) {
        int n = 0;
        String query = "DELETE FROM [dbo].[news] WHERE [newID] = ?";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, news.getNewId());
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    
    public static void main(String[] args) {
        EditNewsDAO dao = new EditNewsDAO();
        News news = dao.getNewsById(32);
        System.out.println(news.getNewId());
    }
}
