/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class SeRenter {

    private int renterID;
    private int userID;
    private int roomID;
    private boolean renterStatus;
    private boolean renterHaveRoom;

    public SeRenter() {
    }

    public SeRenter(int renterID, int userID, int roomID, boolean renterStatus, boolean renterHaveRoom) {
        this.renterID = renterID;
        this.userID = userID;
        this.roomID = roomID;
        this.renterStatus = renterStatus;
        this.renterHaveRoom = renterHaveRoom;
    }

    public int getRenterID() {
        return renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
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

}
