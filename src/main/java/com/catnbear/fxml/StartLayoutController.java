package com.catnbear.fxml;

import com.catnbear.database.Budget;
import com.catnbear.database.DataModel;
import com.catnbear.database.query.Query;
import com.catnbear.utlilities.GuiModifier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.*;

public class StartLayoutController {

    @FXML
    private TableView<Budget> tableView;

    @FXML
    private VBox mainPane;

    @FXML
    HBox rootPane;
    
    private DataModel dataModel;


    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        dataModel.setTableView(tableView);
        dataModel.getDataFilter().setTableName("notmyf4ulty_budget");
        dataModel.getDataFilter().setDatabaseName("wimm");
    }

    public TableView<Budget> getTableView() {
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
        GuiModifier.openNewWindow("/fxml/addentrybox.fxml",this);
    }

    @FXML
    private void filtersButtonClicked() {
        GuiModifier.openNewWindow("/fxml/filters.fxml",this);
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
        int index = Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getId());
        try {
            dataModel.removeFromTable(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
