package com.catnbear.database.table;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.apache.commons.lang.StringUtils;

/**
 * Created by przemek on 27.09.16.
 */
public class ColumnValue {
    public enum ColumnType {
        STRING,
        NUMBER
    }

    ColumnType columnType;
    String value;

    public ColumnValue(ColumnType columnType, String value) {
        this.columnType = columnType;
        this.value = value;
    }

    public String getValue() {
        String result = "";
        switch (columnType) {
            case STRING:
                result = "\"" + value + "\"";
                break;
            case NUMBER:
                if (StringUtils.isNumeric(value)) {
                    result = value;
                } else {
                    throw new IllegalArgumentException();
                }
                break;
        }
        return result;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return getValue();
    }
}
