package com.catnbear.database.table;

public class TableCell {
    String columnName;
    ColumnValue columnValue;

    public TableCell(String columnName, ColumnValue columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public String toEqualsStatement() {
        return "(" + columnName + "="  + columnValue.toString() + ")";
    }
}
