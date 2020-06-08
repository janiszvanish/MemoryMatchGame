package pl.pjatk.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectDifficultyController {
    @FXML
    private Button easyButton;

    @FXML
    private Button mediumButton;

    @FXML
    private Button hardButton;

    @FXML
    private Button backButton;

    public void easyButtonClicked(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LevelEasy.fxml"));
        } catch (IOException e) {
            errorDialog();
        }
        Scene gameScene = new Scene(root,750,600);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);
    }
    public void mediumButtonClicked(ActionEvent event){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LevelMedium.fxml"));
        } catch (IOException e) {
            errorDialog();
        }
        Scene gameScene = new Scene(root,800,600);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);
    }
    public void hardButtonClicked(ActionEvent event){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LevelHard.fxml"));
        } catch (IOException e) {
            errorDialog();
        }
        Scene gameScene = new Scene(root,850,750);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);

    }
    public void backButtonClicked(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        } catch (IOException e) {
            errorDialog();
        }
        Scene gameScene = new Scene(root,600,400);
        Stage thisStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);
    }
    public void errorDialog(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
    }
}
