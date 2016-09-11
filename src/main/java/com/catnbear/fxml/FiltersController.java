package com.catnbear.fxml;

import com.catnbear.database.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.sql.SQLException;

public class FiltersController {
    @FXML private ChoiceBox yearChoiceBox;
    @FXML private ChoiceBox monthChoiceBox;
    @FXML private ChoiceBox<String> categoryChoiceBox;
    private DataModel dataModel;

    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        try {
            categoryChoiceBox.setItems(DataModel.getInstance().getAllCategories());
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
                    categoryChoiceBox.getSelectionModel().getSelectedItem()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

