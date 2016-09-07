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
        try {
            yearChoiceBox.setItems(DataStuff.getInstance().getAllCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void yearChoiceBoxChosen() {
    }

    @FXML private void monthChoiceBoxChosen() {

    }

    @FXML private void categoryChoiceBoxChosen() {

    }
}

