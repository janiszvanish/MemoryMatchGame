package pl.pjatk.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class GameViewController {
    @FXML
    private Button difficultyButton;

    @FXML
    private Button scoreButton;

    @FXML
    private Button quitButton;

    public void difficultyButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectDifficulty.fxml"));
        Scene gameScene = new Scene(root,600,400);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);
    }
    public void scoreButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Score.fxml"));
        Scene gameScene = new Scene(root,400,400);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);

    }
    public void quitButtonClicked(ActionEvent event){
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }

}
