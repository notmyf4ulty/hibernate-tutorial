package com.catnbear.fxml;

import com.catnbear.database.Budget;
import com.catnbear.database.DataFilter;
import com.catnbear.database.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class FiltersController {
    @FXML private ComboBox yearComboBox;
    @FXML private ComboBox monthComboBox;
    @FXML private ComboBox categoryComboBox;
    @FXML private TextField categoryTextField;
    @FXML private TextField valueTextField;
    private DataModel dataModel;

    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        dataModel.getDataFilter().setDatabaseName("wimm");
        dataModel.getDataFilter().setTableName("notmyf4ulty_budget");
        try {
            categoryComboBox.setItems(DataModel.getInstance().getAllCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void yearChoiceBoxChosen() {
    }

    @FXML private void monthChoiceBoxChosen() {

    }

    @FXML private void categoryChoiceBoxChosen() {
        try {
            dataModel.filterData(
                    "category",
                    categoryComboBox.getSelectionModel().getSelectedItem().toString()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addFilterButtonClicked() {
        dataModel
                .getDataFilter()
                .addVarcharFilter(
                        categoryTextField.getText(),
                        valueTextField.getText()
                );
        try {
            dataModel.showData(dataModel
                    .getDataFilter()
                    .getFilterToQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void resetFiltersButtonClicked() {
        dataModel.getDataFilter().resetFilters();
        try {
            dataModel.showData(dataModel
                    .getDataFilter()
                    .getFilterToQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

