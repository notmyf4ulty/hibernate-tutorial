package com.catnbear.database;
public abstract class Filter {
    protected String columnName;
    protected String cellValue;

    public Filter() {}

    public Filter(String columnName, String cellValue) {
        this.columnName = columnName;
        this.cellValue = cellValue;
    }

    public abstract String toQueryString();

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
