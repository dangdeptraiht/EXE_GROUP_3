/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author ASUS
 */
public class Account {

    private int userID;
    private String userMail;
    private String userPassword;
    private int userRole;
    private User user;

    public Account() {
    }

    public Account(int userRole) {
        this.userRole = userRole;
    }

    public Account(String userMail, String userPassword, int userRole) {
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    
    
    public Account(int userID, String userMail, String userPassword, int userRole) {
        this.userID = userID;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public Account(int userID, String userMail, String userPassword, int userRole, User user) {
        this.userID = userID;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.user = user;
    }
    
    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
