package com.catnbear.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DataModel {
    private static DataModel instance = null;
    private ObservableList<Budget> budgetList;
    private TableView<Budget> tableView;
    private DataFilter dataFilter;
    private String databaseName;
    private String tableName;

    private DataModel() {
        try {
            updateBudgetList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView = new TableView<>();
        dataFilter = new DataFilter();
        databaseName = "wimm";
        tableName = "notmyf4ulty_budget";
        dataFilter.setDatabaseName(databaseName);
        dataFilter.setTableName(tableName);
    }

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public void showData(String query) throws SQLException {
        tableView.setItems(Budget.queryResultToObservableList(query));
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Budget> tableView) {
        this.tableView = tableView;
    }

    private void updateBudgetList() throws SQLException {
        budgetList = Budget.queryResultToObservableList(
                "SELECT * FROM" + databaseName + "." + tableName + ";");
    }

    public void removeFromTable(int tableId) throws SQLException {
        String query = "DELETE FROM wimm.notmyf4ulty_budget WHERE id = " + tableId + ";";
        System.out.println(query);
        DatabaseConnector
                .getInstance()
                .getConnection()
                .createStatement()
                .executeUpdate(query);
    }

    public DataFilter getDataFilter() {
        return dataFilter;
    }

    public void setDataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
    }

    public void updateWithFilters() throws SQLException {
        System.out.println(dataFilter.getFilterToQuery());
        showData(dataFilter.getFilterToQuery());
    }

    public ObservableList<String> getAllCategories() throws SQLException {
        updateBudgetList();

        Set<String> resultSet = new HashSet<>();

        for (Budget budgetElement : budgetList) {
            resultSet.add(budgetElement.getCategory());
        }

        resultSet.forEach(System.out::println);
        return FXCollections.observableArrayList(resultSet);
    }
}
