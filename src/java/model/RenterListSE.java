/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class RenterListSE {

    private int userID;
    private String userAvatar;
    private String userName;
    private String userGender;
    private String userPhone;
    private int renterRoom;

    public RenterListSE() {
    }

    public RenterListSE(int userID, String userAvatar, String userName, String userGender, String userPhone, int renterRoom) {
        this.userID = userID;
        this.userAvatar = userAvatar;
        this.userName = userName;
        this.userGender = userGender;
        this.userPhone = userPhone;
        this.renterRoom = renterRoom;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getRenterRoom() {
        return renterRoom;
    }

    public void setRenterRoom(int renterRoom) {
        this.renterRoom = renterRoom;
    }

    @Override
    public String toString() {
        return "RenterList{" + "userID=" + userID + ", userAvatar=" + userAvatar + ", userName=" + userName + ", userGender=" + userGender + ", userPhone=" + userPhone + ", renterRoom=" + renterRoom + '}';
    }

}
