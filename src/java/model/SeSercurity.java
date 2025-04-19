/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class SeSercurity {
    private int sID;
    private int userID;
    private int sShift;

    public SeSercurity() {
    }

    public SeSercurity(int sID, int userID, int sShift) {
        this.sID = sID;
        this.userID = userID;
        this.sShift = sShift;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getsShift() {
        return sShift;
    }

    public void setsShift(int sShift) {
        this.sShift = sShift;
    }

    @Override
    public String toString() {
        return "Sercurity{" + "sID=" + sID + ", userID=" + userID + ", sShift=" + sShift + '}';
    }
    
}
