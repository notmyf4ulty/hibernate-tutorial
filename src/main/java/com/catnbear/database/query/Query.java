package com.catnbear.database.query;

import com.catnbear.database.DatabaseConnector;
import com.catnbear.database.filter.Filter;
import com.catnbear.database.filter.FiltersList;
import com.catnbear.database.table.TableCell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query {

    protected String databaseName;
    protected String tableName;
    protected List<String> columnsList;

    public Query() {
        this.databaseName = "";
        this.tableName = "";
        this.columnsList = new ArrayList<>();
    }

    public Query(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.columnsList = new ArrayList<>();
    }
    public Query(String databaseName, String tableName, List<String> columnsList) {
        this(databaseName, tableName);
        if (columnsList != null) {
            this.columnsList = columnsList;
        }
    }

    public ResultSet selectAll() {
        DatabaseConnector connector = DatabaseConnector.getInstance();
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + databaseName + "." + tableName + ";";
        try {
            resultSet = connector.executeReadQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet select(FiltersList filtersList) {
        DatabaseConnector connector = DatabaseConnector.getInstance();
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + databaseName + "." + tableName + " "
                + "WHERE " + filtersList.toQueryString() + ";";
        try {
            resultSet = connector.executeReadQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int insert(List<TableCell> tableCellsList) {
        String query = "INSERT INTO " + databaseName + "." + tableName + " ";

        if (!(tableCellsList.isEmpty() || (tableCellsList == null))) {
            query += "(";
            for (TableCell tableCell : tableCellsList) {
                query += tableCell.getColumnName();
                if (tableCellsList.indexOf(tableCell) < (tableCellsList.size() - 1)) {
                    query += ",";
                }
            }

            query += ") VALUES (";

            for (TableCell tableCell : tableCellsList) {
                query += tableCell.getColumnValue().getValue();
                if (tableCellsList.indexOf(tableCell) < (tableCellsList.size() - 1)) {
                    query += ",";
                }
            }
            query += ")";
        } else {
            query = "";
        }

        query += ";";

        DatabaseConnector connector = DatabaseConnector.getInstance();
        int affectedRows = -1;
        try {
            affectedRows = connector.executeWriteQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int delete(TableCell tableCell) {
        String query = "DELETE FROM " + databaseName + "." + tableName + " WHERE " + tableCell.toString() + ";";

        System.out.println(query);

        DatabaseConnector connector = DatabaseConnector.getInstance();
        int affectedRows = -1;
        try {
            affectedRows = connector.executeWriteQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int delete(FiltersList filtersList) {
        String query = "DELETE FROM " + databaseName + "." + tableName + " WHERE " + filtersList.toQueryString() + ";";

        DatabaseConnector connector = DatabaseConnector.getInstance();
        int affectedRows = -1;
        try {
            affectedRows = connector.executeWriteQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public String toExecutableString() {
        return "";
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumnsList() {
        return columnsList;
    }

    public void setColumnsList(List<String> columnsList) {
        this.columnsList = columnsList;
    }
}
