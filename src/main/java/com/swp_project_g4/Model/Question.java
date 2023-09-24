/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

/**
 *
 * @author Thanh Duong
 */
public class Question {

    private int ID;
    private int lessonID;
    private int index;
    private String content;
    private int type;
    private int point;

    public Question() {
    }

    public Question(int ID, int lessonID, int index, String content, int type, int point) {
        this.ID = ID;
        this.lessonID = lessonID;
        this.index = index;
        this.content = content;
        this.type = type;
        this.point = point;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Question{" + "ID=" + ID + ", lessonID=" + lessonID + ", index=" + index + ", content=" + content + ", type=" + type + ", point=" + point + '}';
    }

}
