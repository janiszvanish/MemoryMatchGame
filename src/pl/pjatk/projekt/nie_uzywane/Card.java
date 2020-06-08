package pl.pjatk.projekt.nie_uzywane;

import javafx.scene.image.ImageView;

import java.awt.*;

public class Card extends Button {
    //private ImageView imageReverse = new ImageView("images/revere.png");
    private final int id;
    private boolean matched = false;

    public Card(int id) {
        this.id = id;
    }

    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }
}
