package com.catnbear.fxml;

import com.catnbear.database.Budget;
import com.catnbear.database.DataModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.*;

public class StartLayoutController {
    @FXML private TableView<Budget> tableView;
    @FXML private VBox mainPane;
    private static boolean wasAddButtonClickedBefore = false;
    private DataModel dataModel;


    @FXML
    public void initialize() {
        dataModel = DataModel.getInstance();
        DataModel.getInstance().setTableView(tableView);
    }

    public TableView<Budget> getTableView() {
        return tableView;
    }

    @FXML private void onButtonAction() {
        try {
            dataModel.showData("SELECT * FROM wimm.notmyf4ulty_budget;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void addButtonClicked() {
        wasAddButtonClickedBefore = !wasAddButtonClickedBefore;
        if(wasAddButtonClickedBefore) {
            try {
                Pane pane = (Pane) FXMLLoader.load(getClass().getResource("/fxml/addbudgetbox.fxml"));
                pane.setId("addBudgetBox");
                mainPane.getChildren().add(mainPane.getChildren().indexOf(tableView)+1,pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            mainPane.getChildren().remove(getChildOfId(mainPane,"addBudgetBox"));
        }
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
}
