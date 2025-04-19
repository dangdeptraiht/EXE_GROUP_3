/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class UsagePrice {

    private double eprice, wprice;

    public UsagePrice() {
    }

    public UsagePrice(double eprice, double wprice) {
        this.eprice = eprice;
        this.wprice = wprice;
    }

    public double getEprice() {
        return eprice;
    }

    public void setEprice(double eprice) {
        this.eprice = eprice;
    }

    public double getWprice() {
        return wprice;
    }

    public void setWprice(double wprice) {
        this.wprice = wprice;
    }

}
