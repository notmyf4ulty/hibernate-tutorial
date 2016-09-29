package com.catnbear.utlilities.database;

import com.catnbear.model.DatabaseConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Query {

    private String databaseName;
    private String tableName;

    public Query() {
        this.databaseName = "";
        this.tableName = "";
    }

    public Query(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
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
        String query = "SELECT * FROM " + databaseName + "." + tableName;
        if(!filtersList.isEmpty()) {
            query += " WHERE " + filtersList.toQueryString();
        }
        query += ";";
        DatabaseConnector connector = DatabaseConnector.getInstance();
        ResultSet resultSet = null;
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
                query += tableCell.getCellValue();
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
        String query = "DELETE FROM " + databaseName + "." + tableName;
        if(!filtersList.isEmpty()) {
            query += " WHERE " + filtersList.toQueryString();
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
}
