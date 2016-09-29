package com.catnbear.database.table;

public class TableCell {
    String columnName;
    ColumnType columnType;
    String cellValue;

    ColumnValue columnValue;

    private enum ColumnType {
        STRING,
        NUMBER
    }

    public TableCell(String columnName, ColumnValue columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public TableCell(String columnName, String cellValue) {
        this.columnName = columnName;
        this.cellValue = cellValue;
        this.columnType = ColumnType.STRING;
    }

    public TableCell(String columnName, int cellValue) {
        this.columnName = columnName;
        this.cellValue = Integer.toString(cellValue);
        this.columnType = ColumnType.NUMBER;
    }

    public TableCell(String columnName, double cellValue) {
        this.columnName = columnName;
        this.cellValue = Double.toString(cellValue);
        this.columnType = ColumnType.NUMBER;
    }

    public String toString() {
        String result = "(" + columnName + "=";
        switch (columnType) {
            case STRING:
                result += "\"" + cellValue + "\"";
                break;
            case NUMBER:
                result += cellValue;
                break;
        }
        result += ")";
        return result;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnValue getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(ColumnValue columnValue) {
        this.columnValue = columnValue;
    }
}
