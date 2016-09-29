package com.catnbear.fxml;

import com.catnbear.database.BudgetItem;
import com.catnbear.database.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by przemek on 05.09.16.
 */
public class addEntryBoxController {
    @FXML private TextField dateTextField;
    @FXML private TextField counterPartyTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField subcategoryTextField;
    @FXML private TextField descriptionTextField;
    @FXML private TextField typeTextField;
    @FXML private TextField amountTextField;
    @FXML private Button addBudgetButton;
    @FXML private DatePicker datePicker;
    private DataModel dataModel;

    @FXML
    private void initialize() {
        dataModel = DataModel.getInstance();
    }

    @FXML private void addBudgetButtonClicked() {
        BudgetItem budgetItem = new BudgetItem();
        budgetItem.setDate(datePicker.getValue().toString());
        budgetItem.setCounterParty(counterPartyTextField.getText());
        budgetItem.setCategory(categoryTextField.getText());
        budgetItem.setSubcategory(subcategoryTextField.getText());
        budgetItem.setDescription(descriptionTextField.getText());
        budgetItem.setType(typeTextField.getText());
        budgetItem.setAmount(amountTextField.getText());
        System.out.println(budgetItem.toQuery());
        budgetItem.queryUpdate();
        try {
            DataModel.getInstance().updateData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dataModel.addNewItem(getTextFieldsToValuesList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<String> getTextFieldsToValuesList() {
        List<String> valuesList = new ArrayList<String>();
//        valuesList.add("\"" + datePicker.getValue().toString() + "\"");
//        valuesList.add(textFiledToColumnValue(ColumnValue.ColumnType.STRING, counterPartyTextField));
//        valuesList.add(textFiledToColumnValue(ColumnValue.ColumnType.STRING, categoryTextField));
//        valuesList.add(textFiledToColumnValue(ColumnValue.ColumnType.STRING, subcategoryTextField));
//        valuesList.add(textFiledToColumnValue(ColumnValue.ColumnType.STRING, descriptionTextField));
//        valuesList.add(textFiledToColumnValue(ColumnValue.ColumnType.STRING, typeTextField));
//        valuesList.add(textFiledToColumnValue(ColumnValue.ColumnType.NUMBER, amountTextField));
        return valuesList;
    }
}
