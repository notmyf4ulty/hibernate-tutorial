package com.catnbear.fxml;

import com.catnbear.database.Budget;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

public class StartLayoutController {
    @FXML private TableView<Budget> tableView;
    @FXML private TextField dateTextField;
    @FXML private TextField counterPartyTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField subcategoryTextField;
    @FXML private TextField descriptionTextField;
    @FXML private TextField typeTextField;
    @FXML private TextField amountTextField;

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
        budget.setDate(dateTextField.getText());
        budget.setCounterParty(counterPartyTextField.getText());
        budget.setCategory(categoryTextField.getText());
        budget.setSubcategory(subcategoryTextField.getText());
        budget.setDescription(descriptionTextField.getText());
        budget.setType(typeTextField.getText());
        budget.setAmount(amountTextField.getText());

        budget.queryUpdate();
    }
}
