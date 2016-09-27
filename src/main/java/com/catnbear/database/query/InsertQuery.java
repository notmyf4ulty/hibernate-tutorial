package com.catnbear.database.query;

import com.catnbear.database.filter.FiltersList;
import java.util.List;

public class InsertQuery extends Query {

    List<String> valuesList;

    public InsertQuery(String dataBaseName, String tableName, List columnslist, List valuesList) {
        super(dataBaseName,tableName,columnslist);
        this.valuesList = valuesList;
    }

    @Override
    public String toExecutableString() {
        String result = "INSERT INTO " + datbaseName + "." + tableName + " ";

        if (!(columnsList.isEmpty() || (columnsList == null))) {
            result += "(";
            for (String column : columnsList) {
                result += column;
                if (columnsList.indexOf(column) < (columnsList.size() - 1)) {
                    result += ",";
                }
            }
            result += ") ";
        } else {
            result += " ";
        }

        result += "VALUES ";

        if (!(valuesList.isEmpty() || (valuesList == null))) {
            result += "(";
            for (String column : valuesList) {
                result += column;
                if (valuesList.indexOf(column) < (valuesList.size() - 1)) {
                    result += ",";
                }
            }
            result += ")";
        } else {
            result += "";
        }

        result += ";";
        return result;
    }
}
