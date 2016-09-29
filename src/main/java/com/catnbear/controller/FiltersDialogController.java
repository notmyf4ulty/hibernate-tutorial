package com.catnbear.controller;

import com.catnbear.model.DataModel;
import com.catnbear.utlilities.database.TableCell;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class FiltersDialogController {
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
        TableCell tableCell = new TableCell(categoryTextField.getText(), valueTextField.getText());
        dataModel.getFiltersList().add(tableCell);
        System.out.println(dataModel.getFiltersList().toQueryString());
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

