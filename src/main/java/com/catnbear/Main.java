package com.catnbear;

import com.catnbear.database.Budget;
import com.catnbear.database.DatabaseConnector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.*;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rootlayout.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] argv) {

//        DatabaseConnector connector = DatabaseConnector.getInstance();
//        Connection connection = connector.getConnection();
//        ResultSet resultSet = null;
//        Vector<Budget> budgetVector = new Vector<Budget>();
//        try {
//            Statement statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM wimm.notmyf4ulty_budget;");
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            System.out.println(Budget.validateTable(resultSetMetaData));
//
//            while (resultSet.next()) {
//                budgetVector.add(new Budget(resultSet));
//            }
//            for (Budget i : budgetVector) {
//                System.out.println(i);
//            };
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        launch(argv);
    }
}