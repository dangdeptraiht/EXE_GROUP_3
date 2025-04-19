/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Creep
 */
public class UserDetail{
     private int userID;
    private String userMail;
    private String userPassword;
    private int userRole;
    private User user;
    private String userName;
    private String userGender;
    private String userBirth;
    private String userAddress;
    private String userPhone;
    private String userAvatar;
    private Account account;
    private Renter renter;
    private Room room;
    private Security security;
    private String email;

    public UserDetail() {
    }

    public UserDetail(String userName, String userGender, String userBirth, String userAddress, String userPhone,String userMail, String userAvatar) {
        this.userName = userName;
        this.userGender = userGender;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userMail = userMail;
        this.userAvatar = userAvatar;
    }

    
    
    public UserDetail(int userID, String userMail, String userPassword, int userRole, User user, String userName, String userGender, String userBirth, String userAddress, String userPhone, String userAvatar, Account account, Renter renter, Room room, Security security, String email) {
        this.userID = userID;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.user = user;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userAvatar = userAvatar;
        this.account = account;
        this.renter = renter;
        this.room = room;
        this.security = security;
        this.email = email;
    }

    public UserDetail(int userID, String userName, String userGender, String userBirth, String userAddress, String userPhone, String userAvatar, String userMail, String userPassword, int userRole) {    
        this.userName = userName;
        this.userGender = userGender;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userAvatar = userAvatar;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userID = userID;
        this.userRole = userRole;
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

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
