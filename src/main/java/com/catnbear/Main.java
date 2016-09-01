package com.catnbear;

import com.catnbear.database.Budget;
import com.catnbear.database.DatabaseConnector;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Main {

    public static void main(String[] argv) {

        DatabaseConnector connector = DatabaseConnector.getInstance();
        Connection connection = connector.getConnection();
        ResultSet resultSet = null;
        Vector<Budget> budgetVector = new Vector<Budget>();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM wimm.notmyf4ulty_budget;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println(Budget.validateTable(resultSetMetaData));

            while (resultSet.next()) {
                budgetVector.add(new Budget(resultSet));
            }
            for (Budget i : budgetVector) {
                System.out.println(i);
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}