package com.catnbear.database.filter;

public class StringFilter extends Filter {

    public StringFilter(String columnName, String cellValue) {
        super(columnName, cellValue);
    }

    @Override
    public String toQueryString() {
        return "(" + columnName + "=\"" + cellValue + "\")";
    }
}
