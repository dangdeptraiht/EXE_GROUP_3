/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author Admin
 */
public class RulePenChart {
    private String ruleName;
    private int number;

    public RulePenChart() {
    }

    public RulePenChart(String ruleName, int number) {
        this.ruleName = ruleName;
        this.number = number;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RulePenChart{" + "ruleName=" + ruleName + ", number=" + number + '}';
    }

    
}
