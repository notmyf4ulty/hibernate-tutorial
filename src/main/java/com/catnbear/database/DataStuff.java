package com.catnbear.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Created by przemek on 07.09.16.
 */
public class DataStuff {
    private static DataStuff instance = null;
    private static ObservableList<Budget> budgetList;

    public static void setTableView(TableView<Budget> tableView) {
        DataStuff.tableView = tableView;
    }

    private static TableView<Budget> tableView;

    private DataStuff() {
        try {
            updateBudgetList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView = new TableView();
    }

    public static DataStuff getInstance() {
        if (instance == null) {
            instance = new DataStuff();
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

    public ObservableList<Budget> filterData(String columnName, String columnValue) throws SQLException {
        String query = "SELECT * FROM wimm.notmyf4ulty_budget WHERE "
        + "" + columnName + "=\"" + columnValue + "\";";

        System.out.println(query);

        return Budget.queryResultToObservableList(query);
    }

    private void updateBudgetList() throws SQLException {
        budgetList = Budget.queryResultToObservableList("SELECT * FROM wimm.notmyf4ulty_budget;");
    }


}
