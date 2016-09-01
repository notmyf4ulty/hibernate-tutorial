package com.catnbear;

import com.catnbear.database.DatabaseConnector;

import java.sql.*;

public class Main {

    public static void main(String[] argv) {

        DatabaseConnector connector = DatabaseConnector.getInstance();
        Connection connection = connector.getConnection();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM wimm.notmyf4ulty_budget;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1 ; i <= columnCount ; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}