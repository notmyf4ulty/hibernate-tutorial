package com.catnbear.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by przemek on 01.09.16.
 */
public class Budget {

    public static final int BUDGET_COLUMN_NUMBER = 8;

    public static enum TableValidator {
        TABLE_VALID("TABLE_VALID"),
        TABLE_INVALID("TABLE_INVALID");

        private final String fieldDescription;

        private TableValidator(String value) {
            fieldDescription = value;
        }

        public String toString() {
            return fieldDescription;
        }
    }
    private static final String [] TABLE_COLUMNS_NAMES = {
        "id",
        "date",
        "counterparty",
        "category",
        "subcategory",
        "description",
        "type",
        "amount"
    };

    private long id;
    private Date date;
    private String counterParty;
    private String category;
    private String subcategory;
    private String description;
    private String type;
    private double amount;

    public static TableValidator validateTable(ResultSetMetaData resultSetMetaData) throws SQLException {
        if (resultSetMetaData.getColumnCount() != BUDGET_COLUMN_NUMBER) {
            return TableValidator.TABLE_INVALID;
        }
        for (int columnIndex = 1 ; columnIndex <= BUDGET_COLUMN_NUMBER ; columnIndex++) {
            if (!resultSetMetaData.getColumnName(columnIndex).equals(TABLE_COLUMNS_NAMES[columnIndex - 1])) {
                return TableValidator.TABLE_INVALID;
            }
        }
        return TableValidator.TABLE_VALID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
