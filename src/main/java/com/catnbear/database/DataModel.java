package com.catnbear.database;

import com.catnbear.database.filter.FiltersList;
import com.catnbear.database.query.InsertQuery;
import com.catnbear.database.query.Query;
import com.catnbear.database.query.SelectQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.sql.SQLException;
import java.util.*;

public class DataModel {
    private static DataModel instance = null;
    private ObservableList<Budget> budgetList;
    private TableView<Budget> tableView;
    private DataFilter dataFilter;
    private String databaseName;
    private String tableName;

    private final String ID_COLUMN = "id";
    private final String DATE_COLUMN = "date";
    private final String COUNTERPARTY_COLUMN = "counterparty";
    private final String CATEGORY_COLUMN = "category";
    private final String SUBCATEGORY_COLUMN = "subcategory";
    private final String DESCRIPTION_COLUMN = "description";
    private final String TYPE_COLUMN = "type";
    private final String AMOUNT_COLUMN = "amount";
    private final List<String> visibleColumnsList = new ArrayList<>(Arrays.asList(
            new String [] {
                    DATE_COLUMN,
                    COUNTERPARTY_COLUMN,
                    CATEGORY_COLUMN,
                    SUBCATEGORY_COLUMN,
                    DESCRIPTION_COLUMN,
                    TYPE_COLUMN,
                    AMOUNT_COLUMN
            }));

    private FiltersList filtersList;

    private DataModel() {
        filtersList = new FiltersList();
        databaseName = "wimm";
        tableName = "notmyf4ulty_budget";

        tableView = new TableView<>();
        dataFilter = new DataFilter();

        dataFilter.setDatabaseName(databaseName);
        dataFilter.setTableName(tableName);

        try {
            updateBudgetList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            updateData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public void updateData() throws SQLException {
        Query selectQuery = new SelectQuery(databaseName,tableName,filtersList);
        System.out.println(selectQuery.toExecutableString());
            tableView.setItems(Budget.queryResultToObservableList(selectQuery.toExecutableString()));
    }

    public void addNewItem(List<String> valuesList) throws SQLException {
        Query insertQuery = new InsertQuery(databaseName,tableName,visibleColumnsList,valuesList);
        System.out.println(insertQuery.toExecutableString());
        Budget.queryResultToObservableList(insertQuery.toExecutableString());
        updateData();
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Budget> tableView) {
        this.tableView = tableView;
    }

    private void updateBudgetList() throws SQLException {
        budgetList = Budget.queryResultToObservableList(
                "SELECT * FROM " + databaseName + "." + tableName + ";");
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

    public FiltersList getFiltersList() {
        return filtersList;
    }

    public void setFiltersList(FiltersList filtersList) {
        this.filtersList = filtersList;
    }
}
