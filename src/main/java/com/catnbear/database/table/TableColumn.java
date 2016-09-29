package com.catnbear.database.table;

public class TableColumn {
    private String columnName;
    private int tableIndex;
    private int resultSetIndex;

    public TableColumn(String columnName, int tableIndex) {
        this.columnName = columnName;
        this.tableIndex = tableIndex;
        this.resultSetIndex = tableIndex + 1;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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
