/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Date;
import model.News;

/**
 *
 * @author pc
 */
public class AddnewsDAO extends DBContext{

    public int insertNews(News news) {
        int n = 0;
        String query = "INSERT INTO [dbo].[news]\n"
                + "           ([newTitle]\n"
                + "           ,[description]\n"
                + "           ,[img]\n"
                + "           ,[creatAt])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
         try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, news.getNewTitle());
             ps.setString(2, news.getDescription());
             ps.setString(3, news.getImg());
             ps.setString(4, news.getCreateAt());
        
         n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    
    public static void main(String[] args) {
        AddnewsDAO dao = new AddnewsDAO();
        int news = dao.insertNews(new News("test", "test", "img", "10/07/2024"));
        
        if (news > 0) {
            System.out.println("done");
        } else {
            System.out.println("fail");
        }
    
    }
}
