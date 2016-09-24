package com.catnbear.database;
public class Filter {
    String columnName;
    String cellValue;

    public Filter(String columnName, String cellValue) {
        this.columnName = columnName;
        this.cellValue = cellValue;
    }

    public String toQueryString() {
        return "(" + columnName + "=" + cellValue + ")";
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }
}
