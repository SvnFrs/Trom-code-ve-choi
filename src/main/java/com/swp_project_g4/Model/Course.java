/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Model;

/**
 *
 * @author Thanh Duong
 */
public class Course {

    private int ID;
    private String title;
    private String image;
    private String description;
    private int organizationID;
    private int lecturerID;
    private double unSalePrice;
    private double price;
    private double rate;

    public Course() {
    }

    public Course(int ID, String title, String image, String description, int organizationID, int lecturerID, double unSalePrice, double price, double rate) {
        this.ID = ID;
        this.title = title;
        this.image = image;
        this.description = description;
        this.organizationID = organizationID;
        this.lecturerID = lecturerID;
        this.unSalePrice = unSalePrice;
        this.price = price;
        this.rate = rate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public double getUnSalePrice() {
        return unSalePrice;
    }

    public void setUnSalePrice(double unSalePrice) {
        this.unSalePrice = unSalePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Course{" + "ID=" + ID + ", title=" + title + ", image=" + image + ", description=" + description + ", organizationID=" + organizationID + ", lecturerID=" + lecturerID + ", unSalePrice=" + unSalePrice + ", price=" + price + ", rate=" + rate + '}';
    }

}
