package pl.pjatk.projekt.nie_uzywane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class OLDGameViewController {
    @FXML
    private Label timer;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton radioEasy;
    @FXML
    private RadioButton radioMedium;
    @FXML
    private RadioButton radioHard;
    @FXML
    private Button startButton;
    @FXML
    private Button scoreButton;
    @FXML
    private Button quitButton;
    @FXML
    private Pane placeForBoard;

    public void setRadioDisable(){
        radioMedium.setDisable(true);
        radioEasy.setDisable(true);
        radioHard.setDisable(true);
    }

    public int whichRadioButtonSelected() {
        setRadioDisable();
        if(group.getSelectedToggle() != null){
           startButton.setDisable(false);
            if(group.getSelectedToggle() == radioEasy){
                return 6;
            } else if(group.getSelectedToggle() == radioMedium){
                return 12;
            } else {
                return 18;
            }
        } else{
            startButton.setDisable(true);
            return 0;
        }
    }
    public void startButtonClicked(){
        whichRadioButtonSelected();
        startButton.setDisable(true);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("EasyLvl.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BtnClicked(root);

    }
    private void BtnClicked(Parent root){
        Scene scene = new Scene(root,750,500);
        Stage thisStage = (Stage) startButton.getScene().getWindow();
        thisStage.setScene(scene);
    }
}
