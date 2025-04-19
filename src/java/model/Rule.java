/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Creep
 */
public class Rule {
    private int ruleID;
    private String ruleName;
    private String img;
    private int scoreChange;
    private double penMoney;

    public Rule() {
    }

    public Rule(int ruleID, String ruleName, String img, int scoreChange, double penMoney) {
        this.ruleID = ruleID;
        this.ruleName = ruleName;
        this.img = img;
        this.scoreChange = scoreChange;
        this.penMoney = penMoney;
    }

    public int getRuleID() {
        return ruleID;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    public double getPenMoney() {
        return penMoney;
    }

    public void setPenMoney(double penMoney) {
        this.penMoney = penMoney;
    }
    
    
}
