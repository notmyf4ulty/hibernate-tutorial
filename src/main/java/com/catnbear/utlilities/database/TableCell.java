package com.catnbear.utlilities.database;

public class TableCell {
    private String columnName;
    private ColumnType columnType;
    private String cellValue;

    private enum ColumnType {
        STRING,
        NUMBER
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
        result += getCellValue();
        result += ")";
        return result;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getCellValue() {
        String result = "";
        switch (columnType) {
            case STRING:
                result = "\"" + cellValue + "\"";
                break;
            case NUMBER:
                result = cellValue;
                break;
        }
        return result;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }
}
