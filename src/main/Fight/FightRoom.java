package main.Fight;

import main.Card.Card;

import java.util.ArrayList;

public class FightRoom {
    private ArrayList<Opponent> opponents;
    private Potion potion;
    private int nbTurns;

    public FightRoom(ArrayList<Opponent> opponents, Potion potion, int nbTurns) {
        this.opponents = opponents;
        this.potion = potion;
        this.nbTurns = nbTurns;
    }

    public void useCard(Card card) {
        // ...
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
