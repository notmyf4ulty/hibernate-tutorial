package com.catnbear.model.filter;

import com.catnbear.utlilities.database.Filter;
import com.catnbear.utlilities.database.FiltersList;
import com.catnbear.utlilities.database.NumericFilter;
import com.catnbear.utlilities.database.StringFilter;
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
