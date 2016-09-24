package com.catnbear.database.query;

import com.catnbear.database.filter.FiltersList;

public class SelectQuery extends Query{

    FiltersList filtersList;

    @Override
    public String toExecutableString() {
        String result = "SELECT ";

        if (!columnsList.isEmpty()) {
            result += "(";
            for (String column : columnsList) {
                result += column;
                if (columnsList.indexOf(column) < (columnsList.size() - 1)) {
                    result += ",";
                }
            }
            result += ") ";
        }

        result += "FROM " + datbaseName + "." + tableName + " ";

        if (!filtersList.isEmpty()) {
            result += "WHERE ";
            result += filtersList.toQueryString();
        }

        result += ";";

        return result;
    }
}
