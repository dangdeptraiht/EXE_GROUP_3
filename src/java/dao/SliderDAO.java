/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.News;
import model.Slider;

/**
 *
 * @author quanb
 */
public class SliderDAO extends DBContext {

    public boolean updateSliderStatus(int sliderId, boolean sliderStatus) {
        String sql = "UPDATE Slider SET SliderStatus = ? WHERE SliderId = ?";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, sliderStatus);
            ps.setInt(2, sliderId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Slider> getAllSlider() {
        List<Slider> sliders = new ArrayList<>();
        String sql = "select * from Slider where SliderStatus = 1";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("SliderId"));
                slider.setSliderName(rs.getString("SliderName"));
                slider.setSliderImg(rs.getString("SliderImg"));
                slider.setSliderDate(rs.getString("SliderDate"));
                slider.setSliderStatus(rs.getBoolean("SliderStatus"));
                sliders.add(slider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sliders;
    }

    public List<Slider> getSliderList(int pageIndex, int pageSize) {
        List<Slider> sliders = new ArrayList<>();
        String sql = "SELECT [SliderId],\n"
                + "      [SliderName],\n"
                + "      [SliderImg],\n"
                + "      [SliderDate],\n"
                + "      [SliderStatus]\n"
                + "  FROM [HL_Motel].[dbo].[Slider]\n"
                + "ORDER BY [SliderId]\n"
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
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("SliderId"));
                slider.setSliderName(rs.getString("SliderName"));
                slider.setSliderImg(rs.getString("SliderImg"));
                slider.setSliderDate(rs.getString("SliderDate"));
                slider.setSliderStatus(rs.getBoolean("SliderStatus"));
                sliders.add(slider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sliders;
    }

    public int insertSlider(Slider slider) {
        int n = 0;
        String query = "INSERT INTO [dbo].[Slider]\n"
                + "           ([SliderName]\n"
                + "           ,[SliderStatus]\n"
                + "           ,[SliderImg]\n"
                + "           ,[SliderDate])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, slider.getSliderName());
            ps.setBoolean(2, slider.isSliderStatus());
            ps.setString(3, slider.getSliderImg());
            ps.setString(4, slider.getSliderDate());

            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<Slider> searchByText(int pageIndex, int pageSize, String search) {
        List<Slider> sliders = new ArrayList<>();
        String sql = "SELECT [SliderId],\n"
                + "      [SliderName],\n"
                + "      [SliderImg],\n"
                + "      [SliderDate],\n"
                + "      [SliderStatus]\n"
                + "  FROM [HL_Motel].[dbo].[Slider]\n where SliderName like ? "
                + "ORDER BY [SliderId]\n"
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
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("SliderId"));
                slider.setSliderName(rs.getString("SliderName"));
                slider.setSliderImg(rs.getString("SliderImg"));
                slider.setSliderDate(rs.getString("SliderDate"));
                slider.setSliderStatus(rs.getBoolean("SliderStatus"));

                sliders.add(slider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sliders;
    }

    public int updateSlider(Slider slider) {
        int n = 0;
        String query = "UPDATE [dbo].[Slider] \n"
                + "SET [SliderName] = ?, \n"
                + "    [SliderImg] = ?, \n"
                + "    [SliderDate] = ? \n"
                + "WHERE [SliderID] = ?";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, slider.getSliderName());
            ps.setString(2, slider.getSliderImg());
            ps.setString(3, slider.getSliderDate());
            ps.setInt(4, slider.getSliderId());

            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();  // In thông báo lỗi ra console để dễ dàng gỡ lỗi
        }
        return n;
    }

    public Slider getSliderById(int sliderId) {
        Slider slider = null;
        String query = "SELECT * FROM [dbo].[Slider] WHERE SliderId = ?";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, sliderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                slider = new Slider();
                slider.setSliderId(rs.getInt("SliderId"));
                slider.setSliderName(rs.getString("SliderName"));
                slider.setSliderImg(rs.getString("SliderImg"));
                slider.setSliderDate(rs.getString("SliderDate"));
                slider.setSliderStatus(rs.getBoolean("SliderStatus"));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slider;
    }

    public List<Slider> getSliderDetails(int sliderId) {
        List<Slider> sliders = new ArrayList<>();
        String sql = "SELECT [SliderId]\n"
                + "      ,[SliderName]\n"
                + "      ,[SliderImg]\n"
                + "      ,[SliderDate]\n"
                + "      ,[SliderStatus]\n"
                + "  FROM [HL_Motel].[dbo].[Slider] where SliderId = ?";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sliderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("SliderId"));
                slider.setSliderName(rs.getString("SliderName"));
                slider.setSliderImg(rs.getString("SliderImg"));
                slider.setSliderDate(rs.getString("SliderDate"));
                slider.setSliderStatus(rs.getBoolean("SliderStatus"));

                sliders.add(slider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sliders;
    }

    public int Deleteslider(Slider slider) {
        int n = 0;
        String query = "DELETE FROM [dbo].[Slider] WHERE [SliderId] = ?";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, slider.getSliderId());
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        SliderDAO sliderDAO = new SliderDAO();
        Slider slider = new Slider();
        slider.setSliderId(1012);  // ID của slider mà bạn muốn cập nhật
        slider.setSliderName("New Slider Name");
        slider.setSliderImg("New Image Base64 String");  // Thay thế bằng base64 string thực tế
        slider.setSliderDate("2024-08-24");
        int result = sliderDAO.updateSlider(slider);

        // Kiểm tra kết quả
        if (result > 0) {
            System.out.println("Slider updated successfully!");
        } else {
            System.out.println("Failed to update slider.");
        }

    }
}
