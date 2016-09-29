package com.catnbear.database;

import com.catnbear.database.filter.FiltersList;
import com.catnbear.database.query.InsertQuery;
import com.catnbear.database.query.Query;
import com.catnbear.database.table.TableCell;
import javafx.scene.control.TableView;
import java.sql.SQLException;
import java.util.*;

public class DataModel {
    private static DataModel instance = null;
    private TableView<BudgetItem> tableView;
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
    }

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public void updateData() throws SQLException {
        Query query = new Query(databaseName,tableName);
        tableView.setItems(BudgetItem.resultSetToList(query.selectAll()));
    }

    public void addNewItem(List<TableCell> tableCellsList) throws SQLException {
//        InsertQuery insertQuery = new InsertQuery(databaseName,tableName,visibleColumnsList,valuesList);
//        System.out.println(insertQuery.toExecutableString());
//        BudgetItem.queryResultToObservableList(insertQuery.toExecutableString());
//        updateData();
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
