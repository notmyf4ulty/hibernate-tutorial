package com.catnbear.customcontrols;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class ImageButton extends StackPane {
    @FXML
    private Button button;
    private Image image;
    private StringProperty url;

    public ImageButton() {
        url = new SimpleStringProperty();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/customcontrols/imagebutton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try

        {
            fxmlLoader.load();
        } catch(
                IOException exception)

        {
            exception.printStackTrace();
        }

    }
    /**
     * Button's onAction property. If value is null assigns empty event.
     * @return Button's onAction property.
     */
    private ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {

        if (button.onActionProperty().getValue() == null) {
            button.setOnAction(event -> {});
        }

        return button.onActionProperty();
    }

    /**
     * Setter of the onButtonAction property.
     * @param handler Button's nee handler method.
     */
    public final void setOnAction(EventHandler<ActionEvent> handler) {
        button.onActionProperty().set(handler);
    }

    /**
     * Getter of the onButtonAction property.
     * @return Button's handler method.
     */
    public final EventHandler<ActionEvent> getOnAction() {
        return button.onActionProperty().get();
    }

    private StringProperty urlPorperty() {
        return url;
    }

    public String getUrl() {
        return urlPorperty().get();
    }

    public void setUrl(String value) {
        urlPorperty().set(value);
        Image image = new Image(getClass().getResourceAsStream(urlPorperty().get()));
        button.setGraphic(new ImageView(image));
    }
}
