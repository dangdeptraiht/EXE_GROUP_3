/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;




import model.Rule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Penalty;

/**
 *
 * @author Admin
 */
public class RuleDAO extends DBContext {
    public List<Rule> getRule() {
        List<Rule> rule = new ArrayList<>();
            String sql = "SELECT [ruleID]\n" +
                            "      ,[ruleName]\n" +
                            "      ,[img]\n" +
                            "      ,[penMoney]\n" +
                            "  FROM [HL_Motel].[dbo].[rule]";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rule Rule = new Rule();

                Rule.setRuleID(rs.getInt("ruleId"));
                Rule.setRuleName(rs.getString("ruleName"));
                Rule.setImg(rs.getString("img"));                             
                Rule.setPenMoney(rs.getFloat("penMoney"));
                rule.add(Rule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rule;    
    }
    
    public ArrayList<Rule> findAll() {
        ArrayList<Rule> rules = new ArrayList<>();
        try {
            String sql = "select * from [rule]";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                rules.add(toRule(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rules;
    }

    public Rule findById(int id) {
        try {
            String sql = "select * from [rule] where ruleID = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return toRule(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void create(Rule rule) {
        try {
            String sql = "insert into [Rule](ruleName, img, scoreChange, penMoney) values (?,?,?,?)";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setString(1, rule.getRuleName());
            ps.setString(2, rule.getImg());
            ps.setInt(3, rule.getScoreChange());
            ps.setDouble(4, rule.getPenMoney());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Rule rule) {
        try {
            String sql = "update [Rule] set ruleName = ?, img = ? , scoreChange = ?, penMoney = ? where ruleID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, rule.getRuleName());
            ps.setString(2, rule.getImg());
            ps.setInt(3, rule.getScoreChange());
            ps.setDouble(4, rule.getPenMoney());
            ps.setInt(5, rule.getRuleID());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRule(int ruleId) {
        try {
            String sql = "delete from [Rule] where ruleID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ruleId);
            
            PenaltyDao dbPenalty = new PenaltyDao();
            List<Penalty> penaltys = dbPenalty.findByRuleId(ruleId);
            for (Penalty penalty : penaltys) {
                dbPenalty.remove(penalty.getPenID());
            }
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Rule toRule(ResultSet rs) throws SQLException {
        Rule rule = new Rule();
        rule.setRuleID(rs.getInt("ruleID"));
        rule.setRuleName(rs.getString("ruleName"));
        rule.setImg(rs.getString("img"));
        rule.setScoreChange(rs.getInt("scoreChange"));
        rule.setPenMoney(rs.getDouble("penMoney"));
        return rule;
    }
    
    public static void main(String[] args) {
        RuleDAO RuleDAO = new RuleDAO();
        List<Rule> rI = RuleDAO.getRule();

        for (Rule rule : rI) {
            System.out.println(rule);

        }
    }
}
