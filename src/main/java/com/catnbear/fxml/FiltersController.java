package com.catnbear.fxml;

import com.catnbear.database.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.sql.SQLException;

public class FiltersController {
    @FXML private ComboBox yearComboBox;
    @FXML private ComboBox monthComboBox;
    @FXML private ComboBox categoryComboBox;
    private DataModel dataModel;

    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
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
}

