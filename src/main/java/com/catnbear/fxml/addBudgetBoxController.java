package com.catnbear.fxml;

import com.catnbear.database.Budget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by przemek on 05.09.16.
 */
public class addBudgetBoxController {
    @FXML private TextField dateTextField;
    @FXML private TextField counterPartyTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField subcategoryTextField;
    @FXML private TextField descriptionTextField;
    @FXML private TextField typeTextField;
    @FXML private TextField amountTextField;
    @FXML private Button addBudgetButton;

    @FXML private void addBudgetButtonClicked() {
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
