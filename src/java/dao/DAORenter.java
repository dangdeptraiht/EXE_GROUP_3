package dao;

import model.News;
import dao.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAORenter extends DBContext {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<News> getAllNews() {
        List<News> list = new ArrayList<>();
        String query = "SELECT * FROM news";
        try {
            conn = connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Assuming the News constructor takes three parameters: String, String, String
                News news = new News(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(news);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions appropriately, such as logging or rethrowing
            e.printStackTrace();
        } finally {
            // Close resources in finally block to ensure they are always closed
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int findUser(String user) throws SQLException {
        String sql = "select * from account where account.userMail = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return 2;
            }
        } catch (SQLException e) {

        }
        return 1;
    }

    public static void main(String[] args) {
        
    }
}
