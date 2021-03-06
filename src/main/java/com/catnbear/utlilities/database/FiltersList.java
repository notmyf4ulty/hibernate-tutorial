package com.catnbear.utlilities.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import static com.catnbear.utlilities.database.FiltersList.FilterListType.*;

public class FiltersList {

    private ArrayList<TableCell> filterList;

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

    public void clear() {
        filterList.clear();
    }
    
    public void remove(int index) {
        filterList.remove(index);
    }

    String toQueryString() {
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

    public ObservableList toObservableList() {
        ArrayList<String> filters = new ArrayList<String>();
        for (TableCell item : filterList) {
            filters.add(item.toString());
        }
        return FXCollections.observableArrayList(filters);
    }

    boolean isEmpty() {
        return filterList.isEmpty();
    }
}
