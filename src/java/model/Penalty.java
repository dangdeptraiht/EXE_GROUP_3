/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.*;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Penalty {

    private int penID;
    private Room roomID;
    private String description;
    private Date penDate;
    private Rule ruleID;
    private int penStatus;
    private String evidenceImg;

    public Penalty() {
    }

    public Penalty(int penID, Room roomID, String description, Date penDate, Rule ruleID, int penStatus, String evidenceImg) {
        this.penID = penID;
        this.roomID = roomID;
        this.description = description;
        this.penDate = penDate;
        this.ruleID = ruleID;
        this.penStatus = penStatus;
        this.evidenceImg = evidenceImg;
    }

    public int getPenID() {
        return penID;
    }

    public void setPenID(int penID) {
        this.penID = penID;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPenDate() {
        return penDate;
    }

    public void setPenDate(Date penDate) {
        this.penDate = penDate;
    }

    public Rule getRuleID() {
        return ruleID;
    }

    public void setRuleID(Rule ruleID) {
        this.ruleID = ruleID;
    }

    public int getPenStatus() {
        return penStatus;
    }

    public void setPenStatus(int penStatus) {
        this.penStatus = penStatus;
    }

    public String getEvidenceImg() {
        return evidenceImg;
    }

    public void setEvidenceImg(String evidenceImg) {
        this.evidenceImg = evidenceImg;
    }

    @Override
    public String toString() {
        return "Penalty{" + "penID=" + penID + ", roomID=" + roomID + ", description=" + description + ", penDate=" + penDate + ", ruleID=" + ruleID + ", penStatus=" + penStatus + ", evidenceImg=" + evidenceImg + '}';
    }

    
}
