package com.catnbear.database.query;

import java.util.List;

public abstract class Query {

    protected String datbaseName;
    protected String tableName;
    protected List<String> columnsList;

    protected Query() {}

    protected Query(String databaseName, String tableName) {
        this.datbaseName = databaseName;
        this.tableName = tableName;
    }
    protected Query(String databaseName, String tableName, List<String> columnsList) {
        this(databaseName, tableName);
        this.columnsList = columnsList;
    }

    public abstract String toExecutableString();
}
