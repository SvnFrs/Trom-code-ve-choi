/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Database;

import com.swp_project_g4.Model.Mooc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Duong
 */
public class MoocDB extends DB {

    public static boolean existMooc(int ID) {
        boolean ok = false;
        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("select ID from mooc where ID = ?");
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getInt("ID") == ID) {
                    ok = true;
                }
            }

            //disconnect to database
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return result
        return ok;
    }

    public static Mooc getMooc(int ID) {
        Mooc mooc = null;

        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("select * from mooc where ID = ?");
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                mooc = new Mooc(
                        resultSet.getInt("ID"),
                        resultSet.getInt("courseID"),
                        resultSet.getInt("index"),
                        resultSet.getString("title"),
                        resultSet.getString("description"));
            }

            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mooc;
    }

    public static ArrayList<Mooc> getMoocsByCourseID(int courseID) {
        ArrayList<Mooc> moocs = new ArrayList<>();

        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("select * from mooc where courseID = ? order by [index]");
            statement.setInt(1, courseID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Mooc mooc = new Mooc(
                        resultSet.getInt("ID"),
                        resultSet.getInt("courseID"),
                        resultSet.getInt("index"),
                        resultSet.getString("title"),
                        resultSet.getString("description"));
                moocs.add(mooc);
            }

            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return moocs;
    }

    public static boolean insertMooc(Mooc mooc) {
        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("insert into mooc(courseID,[index],title,description) values(?,?,?,?)");
            statement.setInt(1, mooc.getCourseID());
            statement.setInt(2, mooc.getIndex());
            statement.setString(3, mooc.getTitle());
            statement.setString(4, mooc.getDescription());
            statement.executeUpdate();

            //disconnect to database
            disconnect();
            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static boolean updateMooc(Mooc mooc) {
        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("update mooc set courseID=?, [index]=?, title=?, description=? where ID=?");
            statement.setInt(1, mooc.getCourseID());
            statement.setInt(2, mooc.getIndex());
            statement.setString(3, mooc.getTitle());
            statement.setString(4, mooc.getDescription());
            statement.setInt(5, mooc.getID());
            statement.executeUpdate();

            //disconnect to database
            disconnect();
            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteMooc(int ID) {
        try {
            if (!existMooc(ID)) {
                return false;
            }
            connect();
            statement = conn.prepareStatement("delete from mooc where ID=?");
            statement.setInt(1, ID);
            statement.execute();
            disconnect();
            if (!existMooc(ID)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getMoocsByCourseID(1));
    }
}
