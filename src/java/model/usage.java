/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import jakarta.annotation.Nullable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class usage {
    private int usageID;
    private int roomID;
    private float electricNum;
    private float waterBlock;
    private Date createAt;
    
    private Date payAt ;

    public usage() {
    }

    public usage(int usageID, int roomID, float electricNum, float waterBlock, Date createAt, Date payAt) {
        this.usageID = usageID;
        this.roomID = roomID;
        this.electricNum = electricNum;
        this.waterBlock = waterBlock;
        this.createAt = createAt;
        this.payAt = payAt;
    }

    public int getUsageID() {
        return usageID;
    }

    public void setUsageID(int usageID) {
        this.usageID = usageID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public float getElectricNum() {
        return electricNum;
    }

    public void setElectricNum(float electricNum) {
        this.electricNum = electricNum;
    }

    public float getWaterBlock() {
        return waterBlock;
    }

    public void setWaterBlock(float waterBlock) {
        this.waterBlock = waterBlock;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Nullable
    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }
    
}
