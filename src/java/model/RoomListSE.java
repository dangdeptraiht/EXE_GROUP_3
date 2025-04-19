/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class RoomListSE {

    private int roomID;
    private int roomFloor;
    private String roomNumber;
    private String roomSize;
    private String roomImg;
    private int sigleBed;

    public RoomListSE() {
    }

    public RoomListSE(int roomID, int roomFloor, String roomNumber, String roomSize, String roomImg, int sigleBed) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
        this.sigleBed = sigleBed;
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

    public int getSigleBed() {
        return sigleBed;
    }

    public void setSigleBed(int sigleBed) {
        this.sigleBed = sigleBed;
    }

    @Override
    public String toString() {
        return "RoomListSE{" + "roomID=" + roomID + ", roomFloor=" + roomFloor + ", roomNumber=" + roomNumber + ", roomSize=" + roomSize + ", roomImg=" + roomImg + ", sigleBed=" + sigleBed + '}';
    }

}
