/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

/**
 *
 * @author Thanh Duong
 */
public class Answer {
    private int ID;
    private String content;
    private boolean correct;
    private int questionID;

    public Answer() {
    }

    public Answer(int ID, String content, boolean correct, int questionID) {
        this.ID = ID;
        this.content = content;
        this.correct = correct;
        this.questionID = questionID;
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "Answer{" + "ID=" + ID + ", content=" + content + ", correct=" + correct + ", questionID=" + questionID + '}';
    }
    
    

    
}
