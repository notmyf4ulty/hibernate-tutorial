package com.catnbear.database.table;

public class TableField {
    String columnName;
    ColumnValue columnValue;

    public TableField(String columnName, ColumnValue columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public String toEqualsStatement() {
        return "(" + columnName + "="  + columnValue.toString() + ")";
    }
}
