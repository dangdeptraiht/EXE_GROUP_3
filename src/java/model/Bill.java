/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Bill {
    private int billID, roomID;
    private double service, electric, water, roomFee, other, penMoney, total;
    private String createAt, deadline, payAt;

    public Bill() {
    }

    public Bill(int billID, int roomID, double service, double electric, double water, double roomFee, double other, double penMoney, String createAt, String deadline, String payAt) {
        this.billID = billID;
        this.roomID = roomID;
        this.service = service;
        this.electric = electric;
        this.water = water;
        this.roomFee = roomFee;
        this.other = other;
        this.penMoney = penMoney;
        this.createAt = createAt;
        this.deadline = deadline;
        this.payAt = payAt;
    }
    
    public Bill(int billID, int roomID, double service, double electric, double water, double other, double penMoney, String createAt, String deadline, String payAt, double total) {
        this.billID = billID;
        this.roomID = roomID;
        this.service = service;
        this.electric = electric;
        this.water = water;
        this.other = other;
        this.penMoney = penMoney;
        this.createAt = createAt;
        this.deadline = deadline;
        this.payAt = payAt;
        this.total = total;
    }

    public Bill(int billID, int roomID, double service, double electric, double water, double roomFee, double other, double penMoney, double total, String createAt, String deadline, String payAt) {
        this.billID = billID;
        this.roomID = roomID;
        this.service = service;
        this.electric = electric;
        this.water = water;
        this.roomFee = roomFee;
        this.other = other;
        this.penMoney = penMoney;
        this.total = total;
        this.createAt = createAt;
        this.deadline = deadline;
        this.payAt = payAt;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(double roomFee) {
        this.roomFee = roomFee;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getPenMoney() {
        return penMoney;
    }

    public void setPenMoney(double penMoney) {
        this.penMoney = penMoney;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPayAt() {
        return payAt;
    }

    public void setPayAt(String payAt) {
        this.payAt = payAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
