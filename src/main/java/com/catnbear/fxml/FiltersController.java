package com.catnbear.fxml;

import com.catnbear.database.DataModel;
import javafx.collections.FXCollections;
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
        dataModel.getDataFilter().setDatabaseName("wimm");
        dataModel.getDataFilter().setTableName("notmyf4ulty_budget");
        updateFiltersListView();
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
        updateFiltersListView();
    }

    @FXML
    private void resetFiltersButtonClicked() {
        dataModel.getDataFilter().resetFilters();
        System.out.println(dataModel.getDataFilter().getAllFilters());
        try {
            dataModel.showData(dataModel
                    .getDataFilter()
                    .getFilterToQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateFiltersListView();
    }

    private void updateFiltersListView() {
        filtersListView.setItems(
                FXCollections.observableArrayList(
                        dataModel
                                .getDataFilter()
                                .getAllFilters()
                                .toArray()));
    }
}

