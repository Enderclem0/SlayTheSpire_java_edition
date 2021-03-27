package main.Fight;

import main.Card.ProtoCard;

import java.util.ArrayList;
import java.util.Objects;

public class FightRoom {
    private final ArrayList<FightEntity> entities;
    private Potion potion;
    private int nbTurns=0;

    public FightRoom(ArrayList<FightEntity> entities, Potion potion) {
        Objects.requireNonNull(entities);
        Objects.requireNonNull(potion);
        this.entities = entities;
        this.potion = potion;
    }

    public void useCard(ProtoCard card,int position) {
        Objects.requireNonNull(card);

        card.effect(this,position);
    }

    public void playOpponentTurn() {
        for (int i = 1;i<entities.size();i++){
            entities.get(i).
        }
    }
    public FightEntity getPlayer(){
        return entities.get(0);
    }

    public int opponentAmount() {
        return entities.size()-1;
    }

    public ArrayList<FightEntity> getAllEntities() {
        return entities;
    }
    public ArrayList<FightEntity> getAllOpponents() {
        ArrayList<FightEntity> opponents = new ArrayList<>();
        for(int i = 1;i<entities.size();i++){
            opponents.add(entities.get(i));
        }
        return opponents;
    }
    public FightEntity getOpponent(int position){
        if (position>entities.size()-1 || position<=0){
            throw new IllegalArgumentException("Position must be above 0 and below the number of entities");
        }
        return entities.get(position);
    }

    public void getOpponentMove() {
        // ...
    }
}
