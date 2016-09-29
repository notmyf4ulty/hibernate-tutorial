package com.catnbear.database;

import com.catnbear.database.table.TableCell;
import com.catnbear.database.table.TableColumn;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.*;

public class BudgetItem {

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

    private static final int BUDGET_COLUMN_AMOUNT = TABLE_COLUMNS_NAMES.length;

    private enum TableValidator {
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

    private static final TableColumn ID_COLUMN = new TableColumn("id",0);
    private static final TableColumn DATE_COLUMN = new TableColumn("date",1);
    private static final TableColumn COUNTERPARTY_COLUMN = new TableColumn("counterparty",2);
    private static final TableColumn CATEGORY_COLUMN = new TableColumn("category",3);
    private static final TableColumn SUBCATEGORY_COLUMN = new TableColumn("subcategory",4);
    private static final TableColumn DESCRIPTION_COLUMN = new TableColumn("description",5);
    private static final TableColumn TYPE_COLUMN = new TableColumn("type",6);
    private static final TableColumn AMOUNT_COLUMN = new TableColumn("amount",7);
    private static final List<TableColumn> COLUMNS_LIST = new ArrayList<>(Arrays.asList(
            ID_COLUMN,
            DATE_COLUMN,
            COUNTERPARTY_COLUMN,
            CATEGORY_COLUMN,
            SUBCATEGORY_COLUMN,
            DESCRIPTION_COLUMN,
            TYPE_COLUMN,
            AMOUNT_COLUMN
    ));

    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    private final SimpleStringProperty date = new SimpleStringProperty("");
    private final SimpleStringProperty counterParty = new SimpleStringProperty("");
    private final SimpleStringProperty category = new SimpleStringProperty("");
    private final SimpleStringProperty subcategory = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty type = new SimpleStringProperty("");
    private final SimpleDoubleProperty amount = new SimpleDoubleProperty(0.0);

    public BudgetItem() {}

    public BudgetItem(ResultSet resultSet) throws SQLException {
        if (validateTable(resultSet.getMetaData()).equals(TableValidator.TABLE_VALID)) {
            id.set(resultSet.getInt(ID_COLUMN.getResultSetIndex()));
            date.set(resultSet.getString(DATE_COLUMN.getResultSetIndex()));
            counterParty.set(resultSet.getString(COUNTERPARTY_COLUMN.getResultSetIndex()));
            category.set(resultSet.getString(CATEGORY_COLUMN.getResultSetIndex()));
            subcategory.set(resultSet.getString(SUBCATEGORY_COLUMN.getResultSetIndex()));
            description.set(resultSet.getString(DESCRIPTION_COLUMN.getResultSetIndex()));
            type.set(resultSet.getString(TYPE_COLUMN.getResultSetIndex()));
            amount.set(resultSet.getDouble(AMOUNT_COLUMN.getResultSetIndex()));
        }
        else {
            System.out.println("En error occured during creation of the BudgetItem object.");
        }
    }

    public List<TableCell> toTableCellsList() {
        List<TableCell> tableCellsList = new ArrayList<>();
        tableCellsList.add(new TableCell("date",date.getValue()));
        tableCellsList.add(new TableCell("counterparty",counterParty.getValue()));
        tableCellsList.add(new TableCell("category",category.getValue()));
        tableCellsList.add(new TableCell("subcategory",subcategory.getValue()));
        tableCellsList.add(new TableCell("description",description.getValue()));
        tableCellsList.add(new TableCell("type",type.getValue()));
        tableCellsList.add(new TableCell("amount",amount.getValue()));
        return tableCellsList;
    }

    public static TableValidator validateTable(ResultSetMetaData resultSetMetaData) throws SQLException {
        if (resultSetMetaData.getColumnCount() != BUDGET_COLUMN_AMOUNT) {
            return TableValidator.TABLE_INVALID;
        }
        for (int columnIndex = 1; columnIndex <= BUDGET_COLUMN_AMOUNT; columnIndex++) {
            if (!resultSetMetaData.getColumnName(columnIndex).equals(TABLE_COLUMNS_NAMES[columnIndex - 1])) {
                return TableValidator.TABLE_INVALID;
            }
        }
        return TableValidator.TABLE_VALID;
    }

    public static TableValidator validateTable(List<TableCell> tableCellsList) {
        if (tableCellsList.size() != BUDGET_COLUMN_AMOUNT) {
            return TableValidator.TABLE_INVALID;
        }
        for (int columnIndex = 0; columnIndex <= BUDGET_COLUMN_AMOUNT; columnIndex++) {
            if(!tableCellsList.get(columnIndex).getColumnName().equals(TABLE_COLUMNS_NAMES[columnIndex])) {
                return TableValidator.TABLE_INVALID;
            }
        }
        return TableValidator.TABLE_VALID;
    }

    public static ObservableList<BudgetItem> resultSetToList(ResultSet resultSet) throws SQLException {
        List<BudgetItem> budgetItemList = new ArrayList<>();

        if(validateTable(resultSet.getMetaData()).equals(TableValidator.TABLE_VALID)) {
            while (resultSet.next()) {
                budgetItemList.add(new BudgetItem(resultSet));
            }
        }

        return FXCollections.observableArrayList(budgetItemList);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
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

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }
}
