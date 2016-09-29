package com.catnbear.controller;

import com.catnbear.model.DataModel;
import com.catnbear.utlilities.database.FiltersList;
import com.catnbear.utlilities.database.TableCell;
import com.sun.javafx.UnmodifiableArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiltersDialogController {
    @FXML private TextField categoryTextField;
    @FXML private TextField valueTextField;

    @FXML
    private ListView filtersListView;
    private FiltersList filtersList;

    private DataModel dataModel;

    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        filtersList = dataModel.getFiltersList();
        updateFiltersListView();
    }

    @FXML
    private void addFilterButtonClicked() {
        TableCell tableCell = new TableCell(categoryTextField.getText(), valueTextField.getText());
        try {
            dataModel.addFilter(tableCell);
            updateFiltersListView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void resetFiltersButtonClicked() {
        try {
            dataModel.clearFilters();
            updateFiltersListView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateFiltersListView() {
        filtersListView.setItems(dataModel.getFiltersList().toObservableList());
    }
}

