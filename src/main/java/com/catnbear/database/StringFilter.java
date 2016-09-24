package com.catnbear.database;

public class StringFilter extends Filter {

    public StringFilter(String columnName, String cellValue) {
        super(columnName, cellValue);
    }

    @Override
    public String toQueryString() {
        return "(" + columnName + "=\"" + cellValue + "\")";
    }
}
