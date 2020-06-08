package pl.pjatk.projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        primaryStage.setTitle("Memory");
        primaryStage.setScene(new Scene(root, 600, 400)); // 2 parametr ustaw na 400

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
