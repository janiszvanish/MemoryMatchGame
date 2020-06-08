package pl.pjatk.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelMediumController implements Initializable {
    private List<String> paths = new ArrayList<>();
    private Map<Integer,String> mapOfPaths = new TreeMap<>();
    private List<ImageView> images = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();

    private int turn = 0;
    private int score = 0;
    private int numberOfPairs = 0;
    private String currentPath;
    private int counter;
    private ImageView firstImage, secondImage;
    private String secondPath;
    private Button lastButton;
    private boolean flag = false;

    @FXML
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10,
            button11, button12, button13, button14, button15, button16, button17, button18, button19, button20,
            button21, button22, button23, startButton, backButton;

    @FXML
    private ImageView image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10,
            image11,  image12,  image13,  image14, image15,  image16,  image17,  image18,  image19,  image20,
            image21, image22,image23;

    @FXML
    private Label attempts;

    public void button0Clicked(ActionEvent actionEvent) { buttonClicked(0); }
    public void button1Clicked(ActionEvent actionEvent) { buttonClicked(1); }
    public void button2Clicked(ActionEvent actionEvent) { buttonClicked(2); }
    public void button3Clicked(ActionEvent actionEvent) { buttonClicked(3); }
    public void button4Clicked(ActionEvent actionEvent) { buttonClicked(4); }
    public void button5Clicked(ActionEvent actionEvent) { buttonClicked(5); }
    public void button6Clicked(ActionEvent actionEvent) { buttonClicked(6); }
    public void button7Clicked(ActionEvent actionEvent) { buttonClicked(7); }
    public void button8Clicked(ActionEvent actionEvent) { buttonClicked(8); }
    public void button9Clicked(ActionEvent actionEvent) { buttonClicked(9); }
    public void button10Clicked(ActionEvent actionEvent) { buttonClicked(10); }
    public void button11Clicked(ActionEvent actionEvent) { buttonClicked(11); }
    public void button12Clicked(ActionEvent actionEvent) { buttonClicked(12); }
    public void button13Clicked(ActionEvent actionEvent) { buttonClicked(13); }
    public void button14Clicked(ActionEvent actionEvent) { buttonClicked(14); }
    public void button15Clicked(ActionEvent actionEvent) { buttonClicked(15); }
    public void button16Clicked(ActionEvent actionEvent) { buttonClicked(16); }
    public void button17Clicked(ActionEvent actionEvent) { buttonClicked(17); }
    public void button18Clicked(ActionEvent actionEvent) { buttonClicked(18); }
    public void button19Clicked(ActionEvent actionEvent) { buttonClicked(19); }
    public void button20Clicked(ActionEvent actionEvent) { buttonClicked(20); }
    public void button21Clicked(ActionEvent actionEvent) { buttonClicked(21); }
    public void button22Clicked(ActionEvent actionEvent) { buttonClicked(22); }
    public void button23Clicked(ActionEvent actionEvent) { buttonClicked(23); }

    public void buttonClicked(int buttonId){
            counter++;
            attempts.setText(String.valueOf(turn));
            currentPath = mapOfPaths.get(buttonId);

            if (counter % 2 != 0) {
                images.get(buttonId).setImage(new Image(currentPath));
                if (counter > 1) {
                    if(flag){
                        firstImage.setImage(new Image("file:src/pl/pjatk/projekt/images/found.png"));
                        secondImage.setImage(new Image("file:src/pl/pjatk/projekt/images/found.png"));
                    } else {
                        firstImage.setImage(new Image("file:src/pl/pjatk/projekt/images/reverse.png"));
                        secondImage.setImage(new Image("file:src/pl/pjatk/projekt/images/reverse.png"));
                    }
                }
            } else {
                if (secondPath == currentPath && lastButton != buttons.get(buttonId)) {
                    turn++;
                    images.get(buttonId).setImage(new Image(currentPath));
                    secondImage.setImage(new Image(secondPath));
                    buttons.get(buttonId).setDisable(true);
                    lastButton.setDisable(true);
                    buttons.get(buttonId).setOpacity(0.5);
                    numberOfPairs++;
                    score += 100;
                    flag = true;
                } else {
                    turn++;
                    images.get(buttonId).setImage(new Image(currentPath));
                    flag = false;
                }
            }
            firstImage = secondImage;
            secondPath = currentPath;
            lastButton = buttons.get(buttonId);
            secondImage = images.get(buttonId);
        if(numberOfPairs == 12){
            if(turn < 20){
                score += 15000;
            } else if(turn < 32){
                score += 5500;
            }else if(turn < 48){
                score += 1500;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Victory!!!");
            alert.setHeaderText("Congratulations!!!");
            alert.setContentText("You found all 8 pairs!\nNumber of moves: " + turn + "\nPoints gained: " + score);
            ImageView imageView = new ImageView(new Image("file:src/pl/pjatk/projekt/images/congrats.png"));
            alert.setGraphic(imageView);
            alert.showAndWait();
            try {
                savingScore(score);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("SelectDifficulty.fxml"));
            } catch (IOException e) {
                errorDialog();
            }
            Scene scene = new Scene(root, 600, 400);
            Stage thisStage = (Stage) buttons.get(buttonId).getScene().getWindow();
            thisStage.setScene(scene);
        }
    }

    static void savingScore(int score) throws FileNotFoundException {
        List<Integer> scoreList = new ArrayList<>();
        File file = new File("src/pl/pjatk/projekt/files/score.txt");
        Scanner scanner = new Scanner(file);
        String str = "";
        int i=0;
        while (scanner.hasNext()) {
            str = (scanner.nextLine());
            scoreList.add(Integer.parseInt(str));
        }
        scoreList.add(score);
        Collections.sort(scoreList);
        Collections.reverse(scoreList);
        scoreList.remove(scoreList.size()-1);

        System.out.println(scoreList);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file);
            fileWriter.write("");
            for(int sc: scoreList){
                fileWriter.write("" + sc + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
        finally { try { fileWriter.close(); } catch (IOException e) { e.printStackTrace(); } }
    }

    public void backButtonClicked(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SelectDifficulty.fxml"));
        } catch (IOException e) {
            errorDialog();
        }
        Scene gameScene = new Scene(root,600,400);
        Stage thisStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);
    }
    public void startButtonClicked(ActionEvent actionEvent){
        for(Button btn : buttons){
            btn.setDisable(false);
        }
        System.out.println(images);
        for(ImageView imgv : images){
            imgv.setImage(new Image("file:src/pl/pjatk/projekt/images/reverse.png"));
        }

        startButton.setDisable(true);
        System.out.println(mapOfPaths);

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImages();
        setButtons();
        for(Button btn : buttons){
            btn.setDisable(true);
        }
        setPaths();
        setMapOfPaths();

    }

    private void setImages() {
        images.add(image0);
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        images.add(image10);
        images.add(image11);
        images.add(image12);
        images.add(image13);
        images.add(image14);
        images.add(image15);
        images.add(image16);
        images.add(image17);
        images.add(image18);
        images.add(image19);
        images.add(image20);
        images.add(image21);
        images.add(image22);
        images.add(image23);
    }

    public void setButtons(){
        buttons.add(button0);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);
        buttons.add(button17);
        buttons.add(button18);
        buttons.add(button19);
        buttons.add(button20);
        buttons.add(button21);
        buttons.add(button22);
        buttons.add(button23);
    }
    public void errorDialog(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
    }
    public void setPaths(){
        paths.add("file:src/pl/pjatk/projekt/images/cards/1.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/1.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/2.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/2.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/3.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/3.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/4.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/4.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/5.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/5.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/6.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/6.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/7.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/7.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/8.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/8.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/9.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/9.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/10.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/10.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/11.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/11.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/12.png");
        paths.add("file:src/pl/pjatk/projekt/images/cards/12.png");
        Collections.shuffle(paths);
    }
    public void setMapOfPaths(){
        int i = 0;
        for(String path : paths){
            mapOfPaths.put(i++, path);
        }
    }
}
