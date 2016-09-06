package com.catnbear.fxml;

import com.catnbear.database.Budget;
import com.catnbear.database.DatabaseConnector;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.Vector;

/**
 * Created by przemek on 01.09.16.
 */
public class StartLayoutController {
    @FXML private TableView tableView;

    @FXML private void onButtonAction() {
        try {
            ObservableList<Budget> list = Budget.queryResultToObservableList("SELECT * FROM wimm.notmyf4ulty_budget;");
            tableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
