package com.catnbear.controller;

import com.catnbear.model.BudgetItem;
import com.catnbear.model.DataModel;
import com.catnbear.utlilities.ResourceUtility;
import com.catnbear.utlilities.javafx.GuiModifier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class StartLayoutController implements Observer {

    @FXML
    private TableView<BudgetItem> tableView;

    @FXML
    private VBox mainPane;

    @FXML
    HBox rootPane;

    @FXML
    private ResourceBundle resources;

    private DataModel dataModel;


    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        dataModel.setTableView(tableView);
        resources = ResourceUtility.TRANSLATION_BUNDLE_ENG;
    }

    public TableView<BudgetItem> getTableView() {
        return tableView;
    }

    @FXML private void onButtonAction() {
        try {
            dataModel.updateData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteButtonClicked() {
        removeSelectedItem();
        try {
            dataModel.updateData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void newAddButtonClicked() {
        GuiModifier.openNewWindow("/fxml/addnewitemdialog.fxml",this);
    }

    @FXML
    private void filtersButtonClicked() {
        GuiModifier.openNewWindow("/fxml/filtersdialog.fxml",this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private Node getChildOfId(Pane pane, String id) {
        ObservableList<Node> children = pane.getChildren();
        for (Node child : children) {
            String childId = child.getId();
            if ((childId != null) && childId.equals(id)) {
                return child;
            }
        }
        return null;
    }

    private int getChildIndexOfId(Pane pane, String id) {
        ObservableList<Node> children = pane.getChildren();
        for (Node child : children) {
            String childId = child.getId();
            if ((childId != null) && childId.equals(id)) {
                return children.indexOf(child);
            }
        }
        return -1;
    }

    private void removeSelectedItem() {
        int index = tableView.getSelectionModel().getSelectedItem().getId();
        try {
            dataModel.removeItem(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
