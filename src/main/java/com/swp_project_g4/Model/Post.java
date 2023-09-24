/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

/**
 *
 * @author Thanh Duong
 */
public class Post {
    private int ID;
    private String content;
    private int lessonID;

    public Post() {
    }

    public Post(int ID, String content, int lessonID) {
        this.ID = ID;
        this.content = content;
        this.lessonID = lessonID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    @Override
    public String toString() {
        return "Post{" + "ID=" + ID + ", content=" + content + ", lessonID=" + lessonID + '}';
    }
    
    
   
    
}
