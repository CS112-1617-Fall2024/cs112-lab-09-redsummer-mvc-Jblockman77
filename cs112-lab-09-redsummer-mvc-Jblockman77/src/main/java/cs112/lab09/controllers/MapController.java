package cs112.lab09.controllers;


import cs112.lab09.EventApplication;
import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MapController {

    @FXML
    private ImageView mapView;

    @FXML
    private Button bisbeeAzButton;

    @FXML
    private Button sanFranciscoCaButton;

    @FXML
    public void initialize(){
        mapView.setImage(new Image(getClass().getResourceAsStream("/images/Red-Summer.jpg")));
    }

    @FXML
    public void viewHistoricalEvent(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EventApplication.class.getResource("event-view.fxml"));
        Parent eventViewParent = loader.load();

        EventController eventController = loader.getController();

        if(actionEvent.getSource() == sanFranciscoCaButton){
            eventController.initData("California", new RevisedHistoricalEvent("a minor riot between Black and white soldiers occurred in the Presidio in San Francisco", new Date(5,15,1919), "a minor riot between Black and white soldiers occurred in the Presidio in San Francisco after a dispute about a Thai soldier who was moved from the \"colored quarters\" to the white military housing. Despite defending our country, housing for Black soldiers was not only segregated but often inferior. Black soldiers also faced increased attacks and other forms of discrimination upon returning home.", "https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en"), new Image(getClass().getResourceAsStream("/images/sanfrancisco.jpg")));
        }
        else if (actionEvent.getSource() == bisbeeAzButton) {
            eventController.initData("Arizona", new RevisedHistoricalEvent("Local police in Bisbee, Arizona attacked the 10th U.S. Cavalry, an African-American unit known as the \"Buffalo Soldiers,\" formed in 1866", new Date(7,13,1919), "Although sources are limited, the attack occurred on the eve of celebrations meant to honor returning soldiers (like in Norfolk, Virginia).", "https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en"), new Image(getClass().getResourceAsStream("/images/bisbee.png")));

        }
        else{
            System.out.println("How did we get here?");
        }

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(eventViewParent));
        stage.setResizable(false);
        stage.show();
    }
}
