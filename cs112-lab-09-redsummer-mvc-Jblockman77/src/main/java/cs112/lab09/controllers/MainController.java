package cs112.lab09.controllers;

import cs112.lab09.MapApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
    @FXML
    private ImageView logoImageView;

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    @FXML
    public void initialize(){
        logoImageView.setImage(new Image(getClass().getResourceAsStream("/images/Red-Summer.jpg")));
    }

    @FXML
    protected void onStartButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent mapView = FXMLLoader.load(MapApplication.class.getResource("map-view.fxml"));
        Scene mapViewScene = new Scene(mapView);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(mapViewScene);
        window.show();
    }
    @FXML
    protected void onQuitButtonClicked(ActionEvent actionEvent){
        Stage closingStage = (Stage) quitButton.getScene().getWindow();
        closingStage.close();
    }
}