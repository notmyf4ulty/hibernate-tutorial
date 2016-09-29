package com.catnbear.model;

import com.catnbear.utlilities.database.FiltersList;
import com.catnbear.utlilities.database.Query;
import com.catnbear.utlilities.database.TableCell;
import javafx.scene.control.TableView;
import java.sql.SQLException;
import java.util.*;

public class DataModel {
    private static DataModel instance = null;
    private TableView<BudgetItem> tableView;
    private String databaseName;
    private String tableName;
    private FiltersList filtersList;

    private DataModel() {
        filtersList = new FiltersList();
        databaseName = "wimm";
        tableName = "notmyf4ulty_budget";
        tableView = new TableView<>();
    }

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public void updateData() throws SQLException {
        Query query = new Query(databaseName,tableName);
        tableView.setItems(BudgetItem.resultSetToBudgetItemList(query.selectAll()));
    }

    public void addNewItem(List<TableCell> tableCellsList) throws SQLException {
        Query query = new Query(databaseName,tableName);
        query.insert(tableCellsList);
        updateData();
    }

    public void removeItem(int id) throws SQLException {
        Query query = new Query(databaseName,tableName);
        TableCell tableCell = new TableCell("id",id);
        query.delete(tableCell);
        updateData();
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView<BudgetItem> tableView) {
        this.tableView = tableView;
    }

    public FiltersList getFiltersList() {
        return filtersList;
    }

    public void setFiltersList(FiltersList filtersList) {
        this.filtersList = filtersList;
    }
}
