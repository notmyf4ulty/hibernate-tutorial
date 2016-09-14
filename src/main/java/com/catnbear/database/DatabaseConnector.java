package com.catnbear.database;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.Vector;

public class DatabaseConnector {

    private static DatabaseConnector instance = null;
    private Connection connection;

    private DatabaseConnector() {
        connection = establishConnection();
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    private Connection establishConnection() {

        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306?zeroDateTimeBehavior=convertToNull",
                            "tutorial",
                            "password");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        if (connection == null) {
            System.out.println("Failed to make connection!");
        }

        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
