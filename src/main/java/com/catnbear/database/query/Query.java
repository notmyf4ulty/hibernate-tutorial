package com.catnbear.database.query;

import com.catnbear.database.DatabaseConnector;
import com.catnbear.database.filter.FiltersList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Query {

    protected String databaseName;
    protected String tableName;
    protected List<String> columnsList;

    protected Query() {
        this.databaseName = "";
        this.tableName = "";
        this.columnsList = new ArrayList<>();
    }

    protected Query(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.columnsList = new ArrayList<>();
    }
    protected Query(String databaseName, String tableName, List<String> columnsList) {
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

    public int add(List<String> columnsList, List<String> valuesList) {
        String query = "INSERT INTO " + databaseName + "." + tableName + " ";

        if (!(columnsList.isEmpty() || (columnsList == null))) {
            query += "(";
            for (String column : columnsList) {
                query += column;
                if (columnsList.indexOf(column) < (columnsList.size() - 1)) {
                    query += ",";
                }
            }
            query += ") ";
        } else {
            query += " ";
        }

        query += "VALUES ";

        if (!(valuesList.isEmpty() || (valuesList == null))) {
            query += "(";
            for (String column : valuesList) {
                query += column;
                if (valuesList.indexOf(column) < (valuesList.size() - 1)) {
                    query += ",";
                }
            }
            query += ")";
        } else {
            query += "";
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

    public int remove(String columnName, String columnValue) {
        String query = "REMOVE FROM " + databaseName + "." + tableName + " WHERE "
                + "\""
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
