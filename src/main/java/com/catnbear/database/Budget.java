package com.catnbear.database;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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

    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");
    private final SimpleStringProperty  counterParty = new SimpleStringProperty("");
    private final SimpleStringProperty  category = new SimpleStringProperty("");
    private final SimpleStringProperty  subcategory = new SimpleStringProperty("");
    private final SimpleStringProperty  description = new SimpleStringProperty("");
    private final SimpleStringProperty  type = new SimpleStringProperty("");
    private final SimpleStringProperty  amount = new SimpleStringProperty("");

    public Budget(ResultSet resultSet) throws SQLException {
        if (validateTable(resultSet.getMetaData()).equals(TableValidator.TABLE_VALID)) {
            id.set(resultSet.getString(ID_COLUMN_INDEX));
            date.set(resultSet.getString(DATE_COLUMN_INDEX));
            counterParty.set(resultSet.getString(COUNTERPARTY_COLUMN_INDEX));
            category.set(resultSet.getString(CATEGORY_COLUMN_INDEX));
            subcategory.set(resultSet.getString(SUBCATEGORY_COLUMN_INDEX));
            description.set(resultSet.getString(DESCRIPTION_COLUMN_INDEX));
            type.set(resultSet.getString(TYPE_COLUMN_INDEX));
            amount.set(resultSet.getString(AMOUNT_COLUMN_INDEX));
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

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getCounterParty() {
        return counterParty.get();
    }

    public SimpleStringProperty counterPartyProperty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty.set(counterParty);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getSubcategory() {
        return subcategory.get();
    }

    public SimpleStringProperty subcategoryProperty() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory.set(subcategory);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }
}
