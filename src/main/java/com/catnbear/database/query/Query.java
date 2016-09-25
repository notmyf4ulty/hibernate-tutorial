package com.catnbear.database.query;

import java.util.ArrayList;
import java.util.List;

public abstract class Query {

    protected String datbaseName;
    protected String tableName;
    protected List<String> columnsList;

    protected Query() {
        this.datbaseName = "";
        this.tableName = "";
        this.columnsList = new ArrayList<>();
    }

    protected Query(String databaseName, String tableName) {
        this.datbaseName = databaseName;
        this.tableName = tableName;
        this.columnsList = new ArrayList<>();
    }
    protected Query(String databaseName, String tableName, List<String> columnsList) {
        this(databaseName, tableName);
        if (columnsList != null) {
            this.columnsList = columnsList;
        }
    }

    public abstract String toExecutableString();

    public String getDatbaseName() {
        return datbaseName;
    }

    public void setDatbaseName(String datbaseName) {
        this.datbaseName = datbaseName;
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
