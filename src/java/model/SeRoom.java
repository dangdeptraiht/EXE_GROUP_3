/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class SeRoom {
    private int roomID;
    private int roomFloor;
    private String roomNumber;
    private int roomItemID;
    private String roomSize;
    private String roomImg;

    public SeRoom() {
    }

    public SeRoom(int roomID, int roomFloor, String roomNumber, int roomItemID, String roomSize, String roomImg) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomItemID = roomItemID;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
    }

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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomItemID() {
        return roomItemID;
    }

    public void setRoomItemID(int roomItemID) {
        this.roomItemID = roomItemID;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomFloor=" + roomFloor + ", roomNumber=" + roomNumber + ", roomItemID=" + roomItemID + ", roomSize=" + roomSize + ", roomImg=" + roomImg + '}';
    }
    
}
