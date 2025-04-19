/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ASUS
 */
public class News {

    private int newId;
    private String newTitle;
    private String description;
    private String img;
    private String createAt;

    public News() {
    }

    public News(int newId, String newTitle, String description) {
        this.newId = newId;
        this.newTitle = newTitle;
        this.description = description;
    }

    public News(String newTitle, String description, String img, String createAt) {
        this.newTitle = newTitle;
        this.description = description;
        this.img = img;
        this.createAt = createAt;
    }

    
    
    public News(int newId, String newTitle, String description, String img, String createAt) {
        this.newId = newId;
        this.newTitle = newTitle;
        this.description = description;
        this.img = img;
        this.createAt = createAt;
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "News{" + "newId=" + newId + ", newTitle=" + newTitle + ", description=" + description + ", img=" + img + ", createAt=" + createAt + '}';
    }

    
    
    
    
}
