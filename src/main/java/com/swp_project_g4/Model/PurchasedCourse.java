/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

/**
 *
 * @author Thanh Duong
 */
public class PurchasedCourse {

    private int userID;
    private int courseID;

    public PurchasedCourse() {
    }

    public PurchasedCourse(int userID, int courseID) {
        this.userID = userID;
        this.courseID = courseID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "PurchasedCourse{" + "userID=" + userID + ", courseID=" + courseID + '}';
    }

}
