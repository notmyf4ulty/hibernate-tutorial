package com.catnbear.controller;

import com.catnbear.model.DataModel;
import com.catnbear.utlilities.database.Filter;
import com.catnbear.utlilities.database.StringFilter;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class FiltersController {
    @FXML private TextField categoryTextField;
    @FXML private TextField valueTextField;

    @FXML
    private ListView filtersListView;

    private DataModel dataModel;

    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        updateFiltersListView();
    }

    @FXML
    private void addFilterButtonClicked() {
        Filter filter = new StringFilter(categoryTextField.getText(), valueTextField.getText());
        dataModel.getFiltersList().add(filter);
        try {
            dataModel.updateData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateFiltersListView();
    }

    @FXML
    private void resetFiltersButtonClicked() {}

    private void updateFiltersListView() {}
}

