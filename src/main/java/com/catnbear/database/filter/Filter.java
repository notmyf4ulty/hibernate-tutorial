package com.catnbear.database.filter;

import com.catnbear.database.table.ColumnValue;
import com.catnbear.database.table.TableCell;

public class Filter {
    protected String columnName;
    protected String cellValue;
    private ColumnValue columnValue;

    protected Filter(String columnName, String cellValue) {
        this.columnName = columnName;
        this.cellValue = cellValue;
    }

    public Filter(ColumnValue columnValue) {
        this.columnValue = columnValue;
    }

    public String toQueryString() {
        return "(" + columnName + "=" + columnValue.toString() + ")";
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
