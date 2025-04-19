/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Creep
 */
public class ReqType {
    private int  reqTypeId;
    private String typeName;

    public ReqType() {
    }

    public ReqType(int reqTypeId, String typeName) {
        this.reqTypeId = reqTypeId;
        this.typeName = typeName;
    }

    public int getReqTypeId() {
        return reqTypeId;
    }

    public void setReqTypeId(int reqTypeId) {
        this.reqTypeId = reqTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
}
