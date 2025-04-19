/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.*;

/**
 *
 * @author Admin
 */
public class RenterPenChart {
    private int roomID;
    private float penMoney;

    public RenterPenChart() {
    }

    public RenterPenChart(int roomID, float penMoney) {
        this.roomID = roomID;
        this.penMoney = penMoney;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public float getPenMoney() {
        return penMoney;
    }

    public void setPenMoney(float penMoney) {
        this.penMoney = penMoney;
    }

 

    @Override
    public String toString() {
        return "RenterPenChart{" + "roomID=" + roomID + ", penMoney=" + penMoney + '}';
    }
    
    
}
