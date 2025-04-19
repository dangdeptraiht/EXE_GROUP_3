/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class SeUserProfile {

    private int seID;
    private int userID;
    private String userName;
    private String userGender;
    private Date userBirth;
    private String userAddress;
    private String userPhone;
    private String userAvatar;
    private String userMail;
    private int xShift;
    private boolean seStatus;

    public SeUserProfile() {
    }

    public SeUserProfile(int seID, int userID, String userName, String userGender, Date userBirth, String userAddress, String userPhone, String userAvatar, String userMail, int xShift, boolean seStatus) {
        this.seID = seID;
        this.userID = userID;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userAvatar = userAvatar;
        this.userMail = userMail;
        this.xShift = xShift;
        this.seStatus = seStatus;
    }

    public int getSeID() {
        return seID;
    }

    public void setSeID(int seID) {
        this.seID = seID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getxShift() {
        return xShift;
    }

    public void setxShift(int xShift) {
        this.xShift = xShift;
    }

    public boolean isSeStatus() {
        return seStatus;
    }

    public void setSeStatus(boolean seStatus) {
        this.seStatus = seStatus;
    }

    @Override
    public String toString() {
        return "seID=" + seID + ", userID=" + userID + ", userName=" + userName + ", userGender=" + userGender + ", userBirth=" + userBirth + ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", userAvatar=" + userAvatar + ", userMail=" + userMail + ", xShift=" + xShift + ", seStatus=" + seStatus + '}';
    }
    
    
    
    
}
