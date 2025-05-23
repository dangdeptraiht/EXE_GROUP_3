/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Vip {
    private int vipID;
    private int vipName;

    public Vip() {
    }

    public Vip(int vipID, int vipName) {
        this.vipID = vipID;
        this.vipName = vipName;
    }

    public int getVipID() {
        return vipID;
    }

    public void setVipID(int vipID) {
        this.vipID = vipID;
    }

    public int getVipName() {
        return vipName;
    }

    public void setVipName(int vipName) {
        this.vipName = vipName;
    }

    @Override
    public String toString() {
        return "Vip{" + "vipID=" + vipID + ", vipName=" + vipName + '}';
    }
    
}
