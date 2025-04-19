/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.*;

/**
 *
 * @author ASUS
 */
public class Item {
    private int itemID;
    private String itemName;
    private String itemImg;

    public Item(int itemID, String itemName, String itemImg) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemImg = itemImg;
    }

    public Item(String itemName, String itemImg) {
        this.itemName = itemName;
        this.itemImg = itemImg;
    }
    
    public Item() {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
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
