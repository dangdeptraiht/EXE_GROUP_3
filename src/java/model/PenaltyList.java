/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PenaltyList {

   private int penId;
    private int reportID;
    private int accuseId;
    private int roomId;
    private int roomNumber;
    private String description;
    private Date penDate;
    private int ruleId;
    private String ruleName;
    public int penStatus;
    public int renterID;

    public PenaltyList() {
    }

    public PenaltyList(int penId, int reportID, int accuseId, int roomId, String description, Date penDate, int ruleId, String ruleName, int penStatus, int renterID) {
        this.penId = penId;
        this.reportID = reportID;
        this.accuseId = accuseId;
        this.roomId = roomId;
        this.description = description;
        this.penDate = penDate;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.penStatus = penStatus;
        this.renterID = renterID;
    }

    

    public PenaltyList(int penId, int roomId, int reportID, int accuseId, String description, Date penDate, int ruleId, String ruleName, int penStatus) {
        this.penId = penId;
        this.roomId = roomId;
        this.reportID = reportID;
        this.accuseId = accuseId;
        this.description = description;
        this.penDate = penDate;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.penStatus = penStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    
    public int getPenId() {
        return penId;
    }

    public void setPenId(int penId) {
        this.penId = penId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getAccuseId() {
        return accuseId;
    }

    public void setAccuseId(int accuseId) {
        this.accuseId = accuseId;
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

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getPenStatus() {
        return penStatus;
    }

    public void setPenStatus(int penStatus) {
        this.penStatus = penStatus;
    }



    public int getRenterID() {
        return renterID;
    }
public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    
    @Override
    public String toString() {
        return penId + ", " + reportID + ", " + accuseId + ", " + roomId + ", " + description + ", " + penDate + ", " + ruleId + ", " + ruleName + ", " + penStatus;
    }
    
}