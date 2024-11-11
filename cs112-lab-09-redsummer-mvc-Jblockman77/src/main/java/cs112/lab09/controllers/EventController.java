package cs112.lab09.controllers;

import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class EventController {

    private RevisedHistoricalEvent event;

    @FXML
    private Label dateLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private  Label description;
    @FXML
    private Label revisedDescription;
    @FXML
    private ImageView historicalEvent;
    @FXML
    private Button closeButton;
    @FXML
    private Hyperlink citation;

    public void initData(String location, RevisedHistoricalEvent newEvent, Image test){
        event = newEvent;
        locationLabel.setText(location);
        dateLabel.setText(event.getEventDay().toString());
        description.setText(event.getDescription());
        revisedDescription.setText(event.getRevisedDescription());
        historicalEvent.setImage(test);
    }

    @FXML
    protected void onCloseButtonClicked(ActionEvent actionEvent){
        Stage closingStage = (Stage) closeButton.getScene().getWindow();
        closingStage.close();
    }

    @FXML
    protected void hyperLinkClicked(ActionEvent actionEvent) throws IOException, URISyntaxException {
        try {
            Desktop.getDesktop().browse(new URI(event.getCitation()));
        } catch (URISyntaxException e) {
            System.out.println("No Link for this citation!");
        }
    }
}
