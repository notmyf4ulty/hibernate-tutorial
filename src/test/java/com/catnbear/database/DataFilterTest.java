package com.catnbear.database;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by przemek on 17.09.16.
 */
public class DataFilterTest {
    private static DataFilter dataFilter;

    @BeforeClass
    public static void initialize() {
        dataFilter = new DataFilter();
    }

    @Test
    public void addFilter_basicString() {
        String expectedValue = "(category = value)";
        String addFilterCategory = "category";
        String addFilterValue = "value";
        assertEquals(expectedValue,dataFilter.addFilter(addFilterCategory,addFilterValue));
    }
}
