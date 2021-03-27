package main.Fight;

import main.Card.Card;

import java.util.ArrayList;

public class FightRoom {
    private ArrayList<Opponent> opponents;
    private Potion potion;
    private int nbTurns=0;

    public FightRoom(ArrayList<Opponent> opponents, Potion potion) {
        this.opponents = opponents;
        this.potion = potion;
    }

    public void useCard(Card card,Target target) {

    }

    public void playOpponentTurn() {
        // ...
    }

    public int entitiesAmount() {
        // ...
    }

    public int getEntities() {
        // ...
    }

    public void getOpponentMove() {
        // ...
    }
}
