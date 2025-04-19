/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class Request {
    private int requestID;
    private int renterID;
    private int requestType;
    private String title;
    private String description;
    private String createAt;
    private String resStatus;
    private User user;

    public Request() {
        
    }

     public Request(int requestID, int renterID, int requestType, String title, String description, String createAt, String resStatus, User user) {
        this.requestID = requestID;
        this.renterID = renterID;
        this.requestType = requestType;
        this.title = title;
        this.description = description;
        this.createAt = createAt;
        this.resStatus = resStatus;
        this.user = user;
    }
   

    public Request(int requestID, int renterID, int requestType, String title, String description, String createAt, String resStatus) {
        this.requestID = requestID;
        this.renterID = renterID;
        this.requestType = requestType;
        this.title = title;
        this.description = description;
        this.createAt = createAt;
        this.resStatus = resStatus;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getRenterID() {
        return renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
