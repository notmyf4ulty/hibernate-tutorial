package com.catnbear.database.query;

import com.catnbear.database.filter.Filter;
import com.catnbear.database.filter.FiltersList;
import com.catnbear.database.filter.NumericFilter;
import com.catnbear.database.filter.StringFilter;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by przemek on 25.09.16.
 */
public class SelectQueryTest {

    static String databaseName;
    static String tableName;
    static String column1;
    static String column2;
    static List<String> singleColumnList;
    static List<String> twoColumnsList;
    static Filter numericFilter;
    static String numericFilterColumn;
    static String numericFilterValue;
    static Filter stringFilter;
    static String stringFilterColumn;
    static String stringFilterValue;
    static FiltersList singleFilterList;
    static FiltersList twoFiltersList;

    @BeforeClass
    public static void staticInitialize() {
        databaseName = "database";
        tableName = "table";
        column1 = "column1";
        column2 = "column2";
        singleColumnList = new ArrayList<>();
        singleColumnList.add(column1);
        twoColumnsList = new ArrayList<>();
        twoColumnsList.add(column1);
        twoColumnsList.add(column2);
        numericFilterColumn = "numericColumn";
        numericFilterValue = "numericValue";
        numericFilter = new NumericFilter(numericFilterColumn,numericFilterValue);
        stringFilterColumn = "stringColumn";
        stringFilterValue = "stringValue";
        stringFilter = new StringFilter(stringFilterColumn,stringFilterValue);
        singleFilterList = new FiltersList(numericFilter);
        twoFiltersList = new FiltersList(numericFilter,stringFilter);
    }

    @Test
    public void toExecutableString_simple() {
        SelectQuery selectQuery = new SelectQuery("database","table");
        String expectedResult = "SELECT * FROM database.table ;";
        assertEquals(expectedResult,selectQuery.toExecutableString());
    }

    @Test
    public void toExecutableString_oneColumn() {
        List<String> columnList = new ArrayList<String>();
        columnList.add("column1");
        SelectQuery selectQuery = new SelectQuery("database","table",columnList);
        String expectedResult = "SELECT (column1) FROM database.table ;";
        assertEquals(expectedResult,selectQuery.toExecutableString());
    }

    @Test
    public void toExecutableString_twoColumns() {
        List<String> columnList = new ArrayList<String>();
        columnList.add("column1");
        columnList.add("column2");
        SelectQuery selectQuery = new SelectQuery("database","table",columnList);
        String expectedResult = "SELECT (column1,column2) FROM database.table ;";
        assertEquals(expectedResult,selectQuery.toExecutableString());
    }

    @Test
    public void toExecutableString_oneNumericFilter() {
        SelectQuery selectQuery = new SelectQuery(databaseName,tableName,singleFilterList);
        String expectedResult = "SELECT * FROM " + databaseName + "." + tableName
                + " WHERE (" + numericFilter.toQueryString() + ");";
        System.out.println(expectedResult);
        assertEquals(expectedResult,selectQuery.toExecutableString());
    }

    @Test
    public void toExecutableString_twoFilters() {
        SelectQuery selectQuery = new SelectQuery(databaseName,tableName,twoFiltersList);
        String expectedResult = "SELECT * FROM " + databaseName + "." + tableName
                + " WHERE (" + numericFilter.toQueryString() + " AND " + stringFilter.toQueryString() + ");";
        System.out.println(expectedResult);
        assertEquals(expectedResult,selectQuery.toExecutableString());
    }
}
