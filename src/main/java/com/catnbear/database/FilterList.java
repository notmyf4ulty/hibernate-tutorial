package com.catnbear.database;

import java.util.ArrayList;
import java.util.Collections;
import static com.catnbear.database.FilterList.FilterListType.*;

public class FilterList {

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

    public FilterList() {
        this.filterList = new ArrayList<>();
        this.filterListType = AND;
    }

    public FilterList(FilterListType filterListType) {
        this.filterList = new ArrayList<>();
        this.filterListType = filterListType;
    }

    public FilterList(Filter ... filterList) {
        this.filterList = new ArrayList<>(filterList.length);
        Collections.addAll(this.filterList, filterList);
        this.filterListType = AND;
    }

    public FilterList(FilterListType filterListType, Filter ... filterList) {
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
}
