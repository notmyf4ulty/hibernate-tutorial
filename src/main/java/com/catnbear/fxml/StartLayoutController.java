package com.catnbear.fxml;

import com.catnbear.database.Budget;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import java.sql.*;

public class StartLayoutController {
    @FXML private TableView<Budget> tableView;

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

        budget.queryUpdate();
    }
}
