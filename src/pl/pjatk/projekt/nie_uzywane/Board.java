package pl.pjatk.projekt.nie_uzywane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;

    public Board() {
        int pairs = 10;
        List<Card> cardsList = new ArrayList<Card>();
        List<Integer> cardVals = new ArrayList<Integer>();

        for (int i = 0; i < pairs; i++) {
            cardVals.add(i);
            cardVals.add(i);
        }
        Collections.shuffle(cardVals);

    }
}
