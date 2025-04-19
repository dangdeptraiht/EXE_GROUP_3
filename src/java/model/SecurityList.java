/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SecurityList {
    
    private int seID;
    private String userName;
    private String userPhone;
    private String userAddress;
    private int xShift;
    private boolean seStatus;
    private String Department;
    private int userID;
    private String userGender;
    private String userMail;
    private String userPassword;
    public SecurityList() {
    }
    
    public SecurityList(int seID, String userName, String userPhone, String userAddress, int xShift, boolean seStatus, String Department,int userID) {
        
        this.seID = seID;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.xShift = xShift;
        this.seStatus = seStatus;
        this.Department = Department;
        this.userID = userID;
    }
    
    public SecurityList(int seID, String userName, String userPhone, String userAddress, int xShift, boolean seStatus, String Department) {
        this.seID = seID;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.xShift = xShift;
        this.seStatus = seStatus;
        this.Department = Department;
    }
    
    public SecurityList(int seID, String userName, String userPhone, int xShift, boolean seStatus, String Department) {
        this.seID = seID;
        this.userName = userName;
        this.userPhone = userPhone;
        this.xShift = xShift;
        this.seStatus = seStatus;
        this.Department = Department;
    }

    

    public SecurityList(int userID, String userName, String userAddress, String userPhone, String userMail, String userPassword, int xShift, String Department, int seID) {
        this.userID = userID;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.xShift = xShift;
        this.Department = Department;
        this.seID = seID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public int getSeID() {
        return seID;
    }

    public void setSeID(int seID) {
        this.seID = seID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "SecurityList{" + "seID=" + seID + ", userName=" + userName + ", userPhone=" + userPhone + ", userAddress=" + userAddress + ", xShift=" + xShift + ", seStatus=" + seStatus + ", Department=" + Department + '}';
    }
    
    
}
