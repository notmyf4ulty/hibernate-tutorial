package com.catnbear.database;

import com.catnbear.database.filter.Filter;
import com.catnbear.database.filter.FiltersList;
import com.catnbear.database.filter.NumericFilter;
import com.catnbear.database.filter.StringFilter;
import org.junit.Test;
import static org.junit.Assert.*;

public class FiltersListTest {
    private FiltersList filtersList;

    @Test
    public void toQueryString_simple() {
        Filter filter1 = new NumericFilter("column1","value1");
        Filter filter2 = new StringFilter("column2","value2");
        filtersList = new FiltersList(FiltersList.FilterListType.AND, filter1, filter2);
        String expectedRestult = "((column1=value1) AND (column2=\"value2\"))";
        assertEquals(filtersList.toQueryString(),expectedRestult);
    }
}
