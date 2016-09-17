package com.catnbear.database;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;
import static org.junit.Assert.*;

public class DataFilterTest {

    private DataFilter dataFilter;

    @Before
    public void initialize() {
        dataFilter = new DataFilter();
    }

    @Test
    public void addVarcharFilter_basicTest() {
        String expectedValue = "(category = \"value\")";
        String addFilterCategory = "category";
        String addFilterValue = "value";
        assertEquals(expectedValue,dataFilter.addVarcharFilter(addFilterCategory,addFilterValue));
    }

    @Test
    public void addNumericFilter_doubleTest() {
        String expectedValue = "(category = 10.0)";
        String addFilterCategory = "category";
        double addFilterValue = 10.0;
        assertEquals(
                expectedValue,
                dataFilter.addNumericFilter(
                        addFilterCategory,
                        Double.toString(addFilterValue)));
    }

    @Test
    public void addNumericFilter_integerTest() {
        String expectedValue = "(category = 10)";
        String addFilterCategory = "category";
        int addFilterValue = 10;
        assertEquals(
                expectedValue,
                dataFilter.addNumericFilter(
                        addFilterCategory,
                        Integer.toString(addFilterValue)));
    }

    @Test
    public void getAllFilters_basicTest() {
        Vector<String> filtersVector = new Vector<>();
        filtersVector.add(dataFilter.addVarcharFilter("category1","value1"));
        filtersVector.add(dataFilter.addVarcharFilter("category2","value2"));
        filtersVector.add(dataFilter.addVarcharFilter("category3","value3"));
        assertEquals(filtersVector,dataFilter.getAllFilters());
    }

    @Test
    public void getFilterToQuery_debugPrint() {
        dataFilter.setDatabaseName("myDatabase");
        dataFilter.setTableName("myTable");
        dataFilter.addVarcharFilter("category1", "value1");
        dataFilter.addNumericFilter("category2", Integer.toString(20));
        dataFilter.addNumericFilter("category2", Double.toString(20));
        dataFilter.addVarcharFilter("category3", "value3");
        System.out.println(dataFilter.getFilterToQuery());
    }
}
