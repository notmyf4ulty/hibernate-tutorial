package com.catnbear.controller;

import com.catnbear.model.BudgetItem;
import com.catnbear.model.DataModel;
import com.catnbear.utlilities.database.FiltersList;
import com.catnbear.utlilities.database.TableCell;
import com.catnbear.utlilities.database.TableColumn;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import java.sql.SQLException;
import java.util.Vector;

public class FiltersDialogController {
    @FXML
    private TextField categoryTextField;

    @FXML
    private TextField valueTextField;

    @FXML
    private ListView filtersListView;

    @FXML
    private ComboBox<TableColumn> filtersComboBox;

    private FiltersList filtersList;
    private DataModel dataModel;

    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        filtersList = dataModel.getFiltersList();
        updateFiltersListView();
        configureFiltersComboBox();
        filtersComboBox.getItems().addAll(
                BudgetItem.getCounterpartyColumn(),
                BudgetItem.getCategoryColumn(),
                BudgetItem.getSubcategoryColumn(),
                BudgetItem.getDescriptionColumn(),
                BudgetItem.getTypeColumn()
        );
        Vector<String> strings = new Vector<>();
    }

    @FXML
    private void addFilterButtonClicked() {
        TableCell tableCell = new TableCell(
                        filtersComboBox.getSelectionModel().getSelectedItem().getColumnName(),
                        valueTextField.getText());
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

    private void configureFiltersComboBox() {
        filtersComboBox.setCellFactory(
                new Callback<ListView<TableColumn>, ListCell<TableColumn>>() {
                    @Override
                    public ListCell<TableColumn> call(ListView<TableColumn> columnsListView) {
                        ListCell<TableColumn> cell = new ListCell<TableColumn>() {
                            @Override
                            protected void updateItem(TableColumn item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setText("");
                                } else {
                                    setText(item.getDisplayedColumnName());
                                }
                            }
                        };
                        return cell;
                    }
                });

        filtersComboBox.setButtonCell(
                new ListCell<TableColumn>() {
                    @Override
                    protected void updateItem(TableColumn item, boolean bln) {
                        super.updateItem(item, bln);
                        if (bln) {
                            setText("");
                        } else {
                            setText(item.getDisplayedColumnName());
                        }
                    }
                });

    }
}

