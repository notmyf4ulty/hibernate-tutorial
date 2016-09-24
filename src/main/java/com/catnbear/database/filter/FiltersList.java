package com.catnbear.database.filter;

import java.util.ArrayList;
import java.util.Collections;
import static com.catnbear.database.filter.FiltersList.FilterListType.*;

public class FiltersList {

    private ArrayList<Filter> filterList;

    enum FilterListType {
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

    public FiltersList(Filter ... filterList) {
        this.filterList = new ArrayList<>(filterList.length);
        Collections.addAll(this.filterList, filterList);
        this.filterListType = AND;
    }

    public FiltersList(FilterListType filterListType, Filter ... filterList) {
        this.filterList = new ArrayList<>(filterList.length);
        Collections.addAll(this.filterList, filterList);
        this.filterListType = filterListType;
    }

    public void addFilter(Filter filter) {
        filterList.add(filter);
    }

    public String toQueryString() {
        String queryBody = "(";

        for (Filter filter : filterList) {
            queryBody += filter.toQueryString();
            if (filterList.indexOf(filter) < (filterList.size() - 1)) {
                queryBody += filterListType.toString();
            } else {
                queryBody += ")";
            }
        }

        return queryBody;
    }

    public boolean isEmpty() {
        return filterList.isEmpty();
    }
}
