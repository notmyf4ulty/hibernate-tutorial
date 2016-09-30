package com.catnbear.utlilities.database;

public class TableColumn {
    private String columnName;
    private String displayedColumnName;
    private int tableIndex;
    private int resultSetIndex;

    public TableColumn(String columnName, int tableIndex) {
        this.columnName = columnName;
        this.tableIndex = tableIndex;
        this.resultSetIndex = tableIndex + 1;
    }

    public TableColumn(String columnName, String displayedColumnName, int tableIndex) {
        this(columnName, tableIndex);
        this.displayedColumnName = displayedColumnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDisplayedColumnName() {
        return displayedColumnName;
    }

    public void setDisplayedColumnName(String displayedColumnName) {
        this.displayedColumnName = displayedColumnName;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
        this.resultSetIndex = tableIndex + 1;
    }

    public int getResultSetIndex() {
        return resultSetIndex;
    }
}
