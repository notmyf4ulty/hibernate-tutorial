package com.catnbear.database.filter;

public class Filter {
    protected String columnName;
    protected String cellValue;

    protected Filter(String columnName, String cellValue) {
        this.columnName = columnName;
        this.cellValue = cellValue;
    }

    public String toQueryString() {
        return "(" + columnName + "=" + "" + ")";
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
