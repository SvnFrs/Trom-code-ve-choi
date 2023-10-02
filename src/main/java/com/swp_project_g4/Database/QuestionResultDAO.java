/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp_project_g4.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Duong
 */
public class QuestionResultDAO extends DBConnection {

    public static boolean CheckQuestionResult(int quizResultID, int questionID, int selectedAnswer) {
        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("select 1 from questionResult where quizResultID = ? and questionID = ? and selectedAnswer = ?");
            statement.setInt(1, quizResultID);
            statement.setInt(2, questionID);
            statement.setInt(3, selectedAnswer);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

            //disconnect to database
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return result
        return false;
    }

    public static boolean CheckQuestionResultCorrect(int quizResultID, int questionID) {
        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("select 1 from\n"
                    + "(select selectedAnswer as ID from questionResult where quizResultID = ? and questionID = ?) a\n"
                    + "full join\n"
                    + "(select ID from answer where questionID = ? and correct = 1) b\n"
                    + "on a.ID = b.ID\n"
                    + "where a.ID is null or b.ID is null");
            statement.setInt(1, quizResultID);
            statement.setInt(2, questionID);
            statement.setInt(3, questionID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return false;
            }

            //disconnect to database
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return result
        return true;
    }

    public static boolean insertQuestionResult(int quizResultID, int questionID, int selectedAnswer) {
        try {
            //connect to database
            connect();

            statement = conn.prepareStatement("insert into questionResult(quizResultID,questionID,selectedAnswer) values(?,?,?)");
            statement.setInt(1, quizResultID);
            statement.setInt(2, questionID);
            statement.setInt(3, selectedAnswer);
            statement.execute();

            //disconnect to database
            disconnect();

            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static void deleteQuestionResultOfQuestion(int quizResultID, int questionID) {
        try {
            connect();
            statement = conn.prepareStatement("delete from questionResult where quizResultID = ? and questionID = ?");
            statement.setInt(1, quizResultID);
            statement.setInt(2, questionID);
            statement.execute();
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        deleteQuestionResultOfQuestion(1, 3);
    }
}
