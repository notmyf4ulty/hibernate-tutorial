package com.catnbear.fxml;

import javafx.fxml.FXML;
import com.catnbear.database.BudgetItem;
import com.catnbear.database.DataModel;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class AddNewItemDialogController {
    @FXML private TextField counterPartyTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField subcategoryTextField;
    @FXML private TextField descriptionTextField;
    @FXML private TextField typeTextField;
    @FXML private TextField amountTextField;
    @FXML private DatePicker datePicker;
    private DataModel dataModel;

    @FXML
    private void initialize() {
        dataModel = DataModel.getInstance();
    }

    @FXML
    private void addBudgetButtonClicked() {
        BudgetItem budgetItem = new BudgetItem();
        budgetItem.setDate(datePicker.getValue().toString());
        budgetItem.setCounterParty(counterPartyTextField.getText());
        budgetItem.setCategory(categoryTextField.getText());
        budgetItem.setSubcategory(subcategoryTextField.getText());
        budgetItem.setDescription(descriptionTextField.getText());
        budgetItem.setType(typeTextField.getText());
        budgetItem.setAmount(Integer.parseInt(amountTextField.getText()));
        try {
            dataModel.addNewItem(budgetItem.toTableCellsList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
