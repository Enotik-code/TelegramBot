package com.company.crib;

import lombok.SneakyThrows;

import java.sql.ResultSet;

import static com.company.connect.ConnectionMySQL.*;

public class Crib {
    @SneakyThrows
    public String getCribDescription(Integer idCrib){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from cribs where idcribs = '"
                + idCrib +"'" );
        while (resultSet.next()) {
            question = resultSet.getString("description");
        }
        resultSet.close();
        endConnection();
        return question;
    }

    @SneakyThrows
    public String getCribPath(Integer idCrib){
        startConnection();
        String question = new String();
        ResultSet resultSet = statement.executeQuery("select * from cribs where idcribs = '"
                + idCrib +"'" );
        while (resultSet.next()) {
            question = resultSet.getString("criPath");
        }
        resultSet.close();
        endConnection();
        return question;
    }
}
