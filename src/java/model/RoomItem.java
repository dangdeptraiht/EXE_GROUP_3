/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class RoomItem {
    private int roomItemID;
    private int roomID;
    private int itemID;
    private int quantity;
    private String itemName;
    private String itemImg;
    public RoomItem() {
    }

        public RoomItem(int roomItemID, int roomID, int itemID, int quantity, String itemName, String itemImg) {
        this.roomItemID = roomItemID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.itemName = itemName;
        this.itemImg = itemImg;
    }
    
    public RoomItem(int roomItemID, int roomID, int itemID, int quantity) {
        this.roomItemID = roomItemID;
        this.roomID = roomID;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public RoomItem(int quantity) {
        this.quantity = quantity;
    }
    
    

    public int getRoomItemID() {
        return roomItemID;
    }

    public void setRoomItemID(int roomItemID) {
        this.roomItemID = roomItemID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }
    
    

    
    
}
