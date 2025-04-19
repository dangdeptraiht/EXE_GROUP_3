package model;

import java.math.BigDecimal;

public class RentDetail {
    private int roomID;
    private int roomFloor;
    private int roomNumber;
    private double roomSize;
    private BigDecimal roomFee;
    private String roomImg;
    private int userID;
    private boolean renterStatus;
    private boolean renterHaveRoom;
    private double balance;

    public RentDetail() {
    }

    public RentDetail(int roomID, int roomFloor, int roomNumber, double roomSize, BigDecimal roomFee, String roomImg, int userID, boolean renterStatus, boolean renterHaveRoom, double balance) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomFee = roomFee;
        this.roomImg = roomImg;
        this.userID = userID;
        this.renterStatus = renterStatus;
        this.renterHaveRoom = renterHaveRoom;
        this.balance = balance;
    }

    

    // Getters and setters for all fields
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(double roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public BigDecimal getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(BigDecimal roomFee) {
        this.roomFee = roomFee;
    }

    
    public boolean isRenterStatus() {
        return renterStatus;
    }

    public void setRenterStatus(boolean renterStatus) {
        this.renterStatus = renterStatus;
    }

    public boolean isRenterHaveRoom() {
        return renterHaveRoom;
    }

    public void setRenterHaveRoom(boolean renterHaveRoom) {
        this.renterHaveRoom = renterHaveRoom;
    }

   

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
