/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class SeTask {
    private int taskID;
    private int from;
    private int to;
    private String title;
    private String des;
    private Date date;

    public SeTask() {
    }

    public SeTask(int taskID, int from, int to, String title, String des, Date date) {
        this.taskID = taskID;
        this.from = from;
        this.to = to;
        this.title = title;
        this.des = des;
        this.date = date;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" + "taskID=" + taskID + ", from=" + from + ", to=" + to + ", title=" + title + ", des=" + des + ", date=" + date + '}';
    }
    
}
