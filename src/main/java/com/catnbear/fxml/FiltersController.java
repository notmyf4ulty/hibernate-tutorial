package com.catnbear.fxml;

import com.catnbear.database.DataModel;
import com.catnbear.database.filter.Filter;
import com.catnbear.database.filter.StringFilter;
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

