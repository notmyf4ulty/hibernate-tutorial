package com.catnbear.fxml;

import com.catnbear.database.Budget;
import com.catnbear.database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by przemek on 01.09.16.
 */
public class StartLayoutController {
    @FXML private TableView tableView;

    @FXML private void onButtonAction() {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Budget> list = FXCollections.observableArrayList(new ArrayList<Budget>(budgetVector));
        tableView.setItems(list);
    }
}
