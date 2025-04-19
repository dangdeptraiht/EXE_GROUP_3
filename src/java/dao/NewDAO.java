/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.DBContext;
import model.News;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewDAO extends DBContext {

    public List<News> getNewsList(int pageIndex, int pageSize) {
        List<News> news = new ArrayList<>();
        String sql = "SELECT [newId],\n"
                + "      [newTitle],\n"
                + "      [description],\n"
                + "      [creatAt],\n"
                + "      [img]\n"
                + "  FROM [HL_Motel].[dbo].[news]\n"
                + "ORDER BY [newID]\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            int offset = (pageIndex - 1) * pageSize;
            ps.setInt(1, offset);
            ps.setInt(2, pageSize);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News News = new News();
                News.setNewId(rs.getInt("newId"));
                News.setCreateAt(rs.getString("creatAt"));
                News.setNewTitle(rs.getString("newTitle"));
                News.setDescription(rs.getString("description"));
                News.setImg(rs.getString("img"));
                news.add(News);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

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

    public List<News> searchByText(int pageIndex, int pageSize, String search) {
        List<News> news = new ArrayList<>();
        String sql = "SELECT [newID],\n"
                + "      [newTitle],\n"
                + "      [description],\n"
                + "      [img],\n"
                + "      [creatAt]\n"
                + "  FROM [HL_Motel].[dbo].[News]\n where newTitle like ? "
                + "ORDER BY [newID]\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            int offset = (pageIndex - 1) * pageSize;
            ps.setString(1, "%" + search + "%");
            ps.setInt(2, offset);
            ps.setInt(3, pageSize);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News newl = new News();

                newl.setNewId(rs.getInt("newID"));
                newl.setNewTitle(rs.getString("newTitle"));
                newl.setDescription(rs.getString("description"));
                newl.setImg(rs.getString("img"));
                newl.setCreateAt(rs.getString("creatAt"));

                news.add(newl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public int updateNews(News news) {
        int n = 0;
        String query = "UPDATE [dbo].[news] \n"
                + "SET [newTitle] = ?, \n"
                + "    [description] = ?, \n"
                + "    [img] = ?, \n"
                + "    [creatAt] = ? \n"
                + "WHERE [newID] = ?";

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
            e.printStackTrace();  // In thông báo lỗi ra console để dễ dàng gỡ lỗi
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

    public List<News> getNewsDetails(int newId) {
        List<News> news = new ArrayList<>();
        String sql = "SELECT [newID]\n"
                + "      ,[creatAt]\n"
                + "      ,[newTitle]\n"
                + "      ,[description]\n"
                + "      ,[img]\n"
                + "  FROM [HL_Motel].[dbo].[news] where newID = ?";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, newId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                News News = new News();

                News.setNewId(rs.getInt("newId"));
                News.setCreateAt(rs.getString("creatAt"));
                News.setNewTitle(rs.getString("newTitle"));
                News.setDescription(rs.getString("description"));
                News.setImg(rs.getString("img"));

                news.add(News);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

//    public static void main(String[] args) {
//        NewDAO NewDAO = new NewDAO();
//        List<News> news = NewDAO.getNewsList();
//        
//        for (News aNew : news) {
//            System.out.println(aNew.getNewId());
//        }
//    }
}
//getNewsDetails("1");
