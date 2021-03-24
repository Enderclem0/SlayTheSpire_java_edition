package main.Fight;

public class FightRoom {
    private ArrayList<Entity> opponents;
    private Potion potion;
    private int nbTurns;

    public FightRoom(ArrayList<Entity> opponents, Potion potion, int nbTurns) {
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
