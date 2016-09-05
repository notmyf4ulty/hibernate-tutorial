package com.catnbear.fxml;

import com.catnbear.database.Budget;
import com.catnbear.database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
        System.out.println(budgetVector.get(1).toQuery());
    }

    @FXML private void addButtonClicked() {
        Budget budget = new Budget();
        budget.setDate("2012-08-21");
        budget.setCounterParty("Kiciaczek");
        budget.setCategory("Rzeczy");
        budget.setSubcategory("Podrzeczy");
        budget.setDescription("Opis");
        budget.setType("Typ");
        budget.setAmount("20");

        DatabaseConnector connector = DatabaseConnector.getInstance();
        Connection connection = connector.getConnection();

        try {
            System.out.println(budget.toQuery());
            connection.createStatement().executeUpdate(budget.toQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
