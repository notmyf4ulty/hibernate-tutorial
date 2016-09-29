package com.catnbear.utlilities.database;

import java.util.ArrayList;
import java.util.Collections;
import static com.catnbear.utlilities.database.FiltersList.FilterListType.*;

public class FiltersList {

    private ArrayList<TableCell> filterList;

    public enum FilterListType {
        OR(" OR "),
        AND(" AND ");

        private String stringValue;

        FilterListType(String stringValue) {
            this.stringValue = stringValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    private FilterListType filterListType;

    public FiltersList() {
        this.filterList = new ArrayList<>();
        this.filterListType = AND;
    }

    public FiltersList(FilterListType filterListType) {
        this.filterList = new ArrayList<>();
        this.filterListType = filterListType;
    }

    public FiltersList(TableCell ... filterList) {
        this.filterList = new ArrayList<>(filterList.length);
        Collections.addAll(this.filterList, filterList);
        this.filterListType = AND;
    }

    public FiltersList(FilterListType filterListType, TableCell ... filterList) {
        this.filterList = new ArrayList<>(filterList.length);
        Collections.addAll(this.filterList, filterList);
        this.filterListType = filterListType;
    }

    public void add(TableCell filter) {
        filterList.add(filter);
    }

    public void add(TableCell ... filters) {
        Collections.addAll(filterList, filters);
    }

    public String toQueryString() {
        String result = "";
        if (!filterList.isEmpty()) {
            result += "(";
            for (TableCell filter : filterList) {
                result += filter.toString();
                if (filterList.indexOf(filter) < (filterList.size() - 1)) {
                    result += filterListType.toString();
                } else {
                    result += ")";
                }
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return filterList.isEmpty();
    }
}
