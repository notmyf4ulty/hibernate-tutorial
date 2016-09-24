package com.catnbear.database;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterListTest {
    private FilterList filterList;

    @Test
    public void toQueryString_simple() {
        Filter filter1 = new NumericFilter("column1","value1");
        Filter filter2 = new StringFilter("column2","value2");
        filterList = new FilterList(FilterList.FilterListType.AND, filter1, filter2);
        String expectedRestult = "((column1=value1) AND (column2=\"value2\"))";
        assertEquals(filterList.toQueryString(),expectedRestult);
    }
}
