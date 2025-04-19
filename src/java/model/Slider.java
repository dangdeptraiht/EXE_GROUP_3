/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quanb
 */
public class Slider {
    private int sliderId;
    private String sliderName;
    private String sliderImg;
    private String sliderDate;
    private boolean sliderStatus;

    public Slider() {
    }

    public Slider(String sliderName, String sliderImg, String sliderDate, boolean sliderStatus) {
        this.sliderName = sliderName;
        this.sliderImg = sliderImg;
        this.sliderDate = sliderDate;
        this.sliderStatus = sliderStatus;
    }

    public Slider(String sliderName, String sliderImg, String sliderDate) {
        this.sliderName = sliderName;
        this.sliderImg = sliderImg;
        this.sliderDate = sliderDate;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public String getSliderName() {
        return sliderName;
    }

    public void setSliderName(String sliderName) {
        this.sliderName = sliderName;
    }

    public String getSliderImg() {
        return sliderImg;
    }

    public void setSliderImg(String sliderImg) {
        this.sliderImg = sliderImg;
    }

    public String getSliderDate() {
        return sliderDate;
    }

    public void setSliderDate(String sliderDate) {
        this.sliderDate = sliderDate;
    }

    public boolean isSliderStatus() {
        return sliderStatus;
    }

    public void setSliderStatus(boolean sliderStatus) {
        this.sliderStatus = sliderStatus;
    }

    @Override
    public String toString() {
        return "Slider{" + "sliderId=" + sliderId + ", sliderName=" + sliderName + ", sliderImg=" + sliderImg + ", sliderDate=" + sliderDate + ", sliderStatus=" + sliderStatus + '}';
    }
    
    
}
