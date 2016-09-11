package com.catnbear.fxml;

import com.catnbear.database.DataStuff;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.sql.SQLException;

public class FiltersController {
    @FXML private ChoiceBox yearChoiceBox;
    @FXML private ChoiceBox monthChoiceBox;
    @FXML private ChoiceBox categoryChoiceBox;
    @FXML StartLayoutController startLayoutController;

    @FXML
    public void initialize() {
        startLayoutController = new StartLayoutController();
        try {
            categoryChoiceBox.setItems(DataStuff.getInstance().getAllCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void yearChoiceBoxChosen() {
    }

    @FXML private void monthChoiceBoxChosen() {

    }

    @FXML private void categoryChoiceBoxChosen() {
        System.out.println(categoryChoiceBox.getSelectionModel().getSelectedItem().toString());
        try {
//            DataStuff.getInstance().filterData("category",
//                    categoryChoiceBox.getSelectionModel().getSelectedItem().toString());
            DataStuff.getInstance().getTableView().setItems(
                    DataStuff.getInstance().filterData("category",
                            categoryChoiceBox.getSelectionModel().getSelectedItem().toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

