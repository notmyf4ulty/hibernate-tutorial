package com.catnbear.database;

public class NumericFilter extends Filter {

    public NumericFilter(String columnName, String cellValue) {
        super(columnName, cellValue);
    }

    @Override
    public String toQueryString() {
        return "(" + columnName + "=" + cellValue + ")";
    }
}
