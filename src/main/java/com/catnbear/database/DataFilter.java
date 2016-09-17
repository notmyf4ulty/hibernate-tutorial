package com.catnbear.database;

import java.util.Vector;

/**
 * Created by przemek on 17.09.16.
 */
public class DataFilter {
    private Vector<String> filtersVector;
    private String databaseName;
    private String tableName;

    public DataFilter() {
        filtersVector = new Vector<>();
        databaseName = "";
        tableName = "";
    }

    public String addVarcharFilter(String columnName, String value) {
        String newFilter = "(" + columnName + " = \"" + value + "\")";
        filtersVector.add(newFilter);
        return newFilter;
    }

    public String addNumericFilter(String columnName, String value) {
        String newFilter = "(" + columnName + " = " + value + ")";
        filtersVector.add(newFilter);
        return newFilter;
    }

    public Vector<String> getAllFilters() {
        return filtersVector;
    }

    public String getFilterToQuery() {
        int filtersVectorLength = filtersVector.size();
        String query = "SELECT * FROM " + databaseName + "." + tableName + " WHERE ";

        for (String filter : filtersVector) {
            query += filter;
            if (filtersVector.indexOf(filter) != filtersVectorLength - 1) {
                query += " AND ";
            }
        }
        query += ";";

        return query;
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
