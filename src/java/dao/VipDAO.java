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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vip;

/**
 *
 * @author Admin
 */
public class VipDAO extends DBContext {

    public List<Vip> getAllVips() {
        List<Vip> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.vip";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("vipID");
                String name = resultSet.getString("vipName").trim();
                Vip vip = new Vip(id, name);
                list.add(vip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
