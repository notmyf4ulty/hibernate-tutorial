package com.catnbear.database;

public class SqlExecutor {
    private String databaseName;
    private String tableName;
    private String databaseTableNameCompound;
    private final String END_QUERY_SIGN = ";";
    private final String SELECT_ALL_FROM_STATEMENT = "SELECT * FROM ";
    private final String WHERE_STATEMENT = "WHERE ";

    public SqlExecutor(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        databaseTableNameCompound = this.databaseName + "." + this.tableName;
    }

    public String selectAll() {
        return SELECT_ALL_FROM_STATEMENT + databaseTableNameCompound + END_QUERY_SIGN;
    }

    public String selectAllWhere(String columnName, String value) {
        return SELECT_ALL_FROM_STATEMENT + databaseName + WHERE_STATEMENT +
                "(" + columnName + "=" + value + ")" + END_QUERY_SIGN;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
