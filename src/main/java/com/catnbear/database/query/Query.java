package com.catnbear.database.query;

import com.catnbear.database.DatabaseConnector;

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
        try {
            connector.executeReadQuery("SELECT * FROM " + databaseName + "." + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
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
