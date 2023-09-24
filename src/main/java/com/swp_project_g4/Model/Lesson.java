/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

/**
 *
 * @author Thanh Duong
 */
public class Lesson {

    private int ID;
    private int moocID;
    private String title;
    private int index;
    private int type;
    private int time;

    public Lesson() {
    }

    public Lesson(int ID, int moocID, String title, int index, int type, int time) {
        this.ID = ID;
        this.moocID = moocID;
        this.title = title;
        this.index = index;
        this.type = type;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMoocID() {
        return moocID;
    }

    public void setMoocID(int moocID) {
        this.moocID = moocID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Lesson{" + "ID=" + ID + ", moocID=" + moocID + ", title=" + title + ", index=" + index + ", type=" + type + ", time=" + time + '}';
    }

}
