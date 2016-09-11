package com.catnbear.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DataModel {
    private static DataModel instance = null;
    private static ObservableList<Budget> budgetList;

    private static String currentQuery;
    private static TableView<Budget> tableView;

    private DataModel() {
        try {
            updateBudgetList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView = new TableView<Budget>();
    }

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public ObservableList<Budget> getBudgetList() throws SQLException {
        updateBudgetList();
        return budgetList;
    }

    public TableView getTableView() {
        return tableView;
    }

    public ObservableList<String> getAllCategories() throws SQLException {
        updateBudgetList();

        Set<String> resultSet = new HashSet<String>();

        for (Budget budgetElement : budgetList) {
            resultSet.add(budgetElement.getCategory());
        }

        for (String category : resultSet) {
            System.out.println(category);
        }
        return FXCollections.observableArrayList(resultSet);
    }

    public void showData(String query) throws SQLException {
        tableView.setItems(Budget.queryResultToObservableList(query));
    }

    public void filterData(String columnName, String columnValue) throws SQLException {
        String query =
                "SELECT * FROM wimm.notmyf4ulty_budget WHERE "
                        + ""
                        + columnName
                        + "=\""
                        + columnValue + "\";";

        tableView.setItems(Budget.queryResultToObservableList(query));
    }

    public static void setTableView(TableView<Budget> tableView) {
        DataModel.tableView = tableView;
    }

    public static String getCurrentQuery() {
        return currentQuery;
    }

    public static void setCurrentQuery(String currentQuery) {
        DataModel.currentQuery = currentQuery;
    }

    private void updateBudgetList() throws SQLException {
        budgetList = Budget.queryResultToObservableList("SELECT * FROM wimm.notmyf4ulty_budget;");
    }


}
