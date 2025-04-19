/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Creep
 */
public class Guideline {
    private int guideID;
    private String guideName;
    private String img;


    public Guideline() {
    }

    public Guideline(int guideID, String guideName, String img) {
        this.guideID = guideID;
        this.guideName = guideName;
        this.img = img;
    }
    
    public Guideline( String guideName, String img) {
        this.guideName = guideName;
        this.img = img;
    }

    public int getGuideID() {
        return guideID;
    }

    public void setGuideID(int guideID) {
        this.guideID = guideID;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

}
