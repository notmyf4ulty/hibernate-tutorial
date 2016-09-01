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

    public enum TableValidator {
        TABLE_VALID("TABLE_VALID"),
        TABLE_INVALID("TABLE_INVALID");

        private final String fieldDescription;

        TableValidator(String value) {
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

    private final int ID_COLUMN_INDEX = 1;
    private final int DATE_COLUMN_INDEX = 2;
    private final int COUNTERPARTY_COLUMN_INDEX = 3;
    private final int CATEGORY_COLUMN_INDEX = 4;
    private final int SUBCATEGORY_COLUMN_INDEX = 5;
    private final int DESCRIPTION_COLUMN_INDEX = 6;
    private final int TYPE_COLUMN_INDEX = 7;
    private final int AMOUNT_COLUMN_INDEX = 8;

    private long id;
    private Date date;
    private String counterParty;
    private String category;
    private String subcategory;
    private String description;
    private String type;
    private double amount;

    public Budget(ResultSet resultSet) throws SQLException {
        if (validateTable(resultSet.getMetaData()).equals(TableValidator.TABLE_VALID)) {
            id = resultSet.getInt(ID_COLUMN_INDEX);
            date = resultSet.getDate(DATE_COLUMN_INDEX);
            counterParty = resultSet.getString(COUNTERPARTY_COLUMN_INDEX);
            category = resultSet.getString(CATEGORY_COLUMN_INDEX);
            subcategory = resultSet.getString(SUBCATEGORY_COLUMN_INDEX);
            description = resultSet.getString(DESCRIPTION_COLUMN_INDEX);
            type = resultSet.getString(TYPE_COLUMN_INDEX);
            amount = resultSet.getDouble(AMOUNT_COLUMN_INDEX);
        }
        else {
            System.out.println("En error occured during creation of the Budget object.");
        }
    }


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

    public String toString() {
        return
                id + " " +
                date + " " +
                counterParty + " " +
                category + " " +
                subcategory + " " +
                description + " " +
                type + " " +
                amount;
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
