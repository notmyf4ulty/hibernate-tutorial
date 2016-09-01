package com.catnbear;

import com.catnbear.database.Budget;
import com.catnbear.database.DatabaseConnector;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] argv) {

        DatabaseConnector connector = DatabaseConnector.getInstance();
        Connection connection = connector.getConnection();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM wimm.notmyf4ulty_budget;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println(Budget.validateTable(resultSetMetaData));

            int columnCount = resultSetMetaData.getColumnCount();
//            List<String>
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