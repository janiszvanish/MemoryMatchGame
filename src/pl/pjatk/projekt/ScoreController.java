package pl.pjatk.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ScoreController implements Initializable {
    @FXML
    private TextArea scoreTextArea;

    @FXML
    private Button backButton;

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
    public void showScore() throws FileNotFoundException {
        File file = new File("src/pl/pjatk/projekt/files/score.txt");
        Scanner scanner = new Scanner(file);
        String str = "";
        int i=0;
        while (scanner.hasNext()) {
            str += (scanner.nextLine() + "\n");
        }
        scoreTextArea.setText(str);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showScore();
        } catch (FileNotFoundException e) {
            errorDialog();
        }
    }
}
