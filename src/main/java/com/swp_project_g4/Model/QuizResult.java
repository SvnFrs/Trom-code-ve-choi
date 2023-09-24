/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

import java.util.Date;

/**
 *
 * @author Thanh Duong
 */
public class QuizResult {

    private int ID;
    private int lessonID;
    private int userID;
    private Date startTime;
    private Date endTime;

    public QuizResult() {
    }

    public QuizResult(int ID, int lessonID, int userID, Date startTime, Date endTime) {
        this.ID = ID;
        this.lessonID = lessonID;
        this.userID = userID;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "QuizResult{" + "ID=" + ID + ", lessonID=" + lessonID + ", userID=" + userID + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }

}
