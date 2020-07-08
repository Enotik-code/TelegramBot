package com.company.questions;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.company.connect.ConnectionMySQL.*;

public class QuestionsServer {
    @SneakyThrows
    public String getQuestion(Integer idQuestion){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from question where idquestion = '" + idQuestion +"'");
        while (resultSet.next()) {
                    question = resultSet.getString("question");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getAnswer(Integer idQuestion){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from question where idquestion = '" + idQuestion +"'");
        while (resultSet.next()) {
            question = resultSet.getString("answer");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getQuestionByLevel(Integer idLevel, Integer idQuestion){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from question where idlevel = '"
                + idLevel +"' and idquestion ='" + idQuestion+"'" );
        while (resultSet.next()) {
            question = resultSet.getString("question");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getAnswerByLevel(Integer idLevel, Integer idQuestion){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from question where idlevel = '"
                + idLevel +"' and idquestion ='" + idQuestion+"'" );
        while (resultSet.next()) {
            question = resultSet.getString("answer");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getQuestionByCategory(Integer idQuestion){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from question where idcategory = '" + idQuestion +"'");
        while (resultSet.next()) {
            question = resultSet.getString("question");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getAnswerByCategory(Integer idQuestion){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from question where idcategory = '" + idQuestion +"'");
        while (resultSet.next()) {
            question = resultSet.getString("answer");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getListOfQuestion(Integer idCategory){
        startConnection();
        int i = 1;
        List<String> lisqQuestion = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from question where idcategory = '" + idCategory +"'");
        while (resultSet.next()) {
            lisqQuestion.add(" \n"+ (i++) +". "+ resultSet.getString("question"));
        }
        resultSet.close();
        endConnection();
         return lisqQuestion.toString().substring(1);
    }
}
