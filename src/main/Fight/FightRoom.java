package main.Fight;

import main.Player;
import main.UI;

import java.util.ArrayList;
import java.util.Objects;

public class FightRoom {
    private final ArrayList<FightEntity> entitiesList;
    private Potion potion;
    private int nbTurns=0;

    public FightRoom(ArrayList<FightEntity> entities, Potion potion) {
        Objects.requireNonNull(entities);
        this.entitiesList = entities;
        this.potion = potion;
    }
    public void playPlayerTurn(){
        PlayerAvatar playerAvatar = getPlayer();
        playerAvatar.draw((nbTurns==0)?5:1);

    }
    public int choseCard(int numberOfCard){
        UI ui = UI.getUI();
        return ui.getUserInput();
    }
    public void playOpponentTurn() {
        ArrayList<Opponent> ennemies = getAllOpponents();
        for (Opponent enemy : ennemies) {
            enemy.playNextAction(getPlayer());
            enemy.randomizeNextAction();
        }
        nbTurns++;
    }
    public PlayerAvatar getPlayer(){
        return (PlayerAvatar) entitiesList.get(0);
    }

    public int opponentAmount() {
        return entitiesList.size()-1;
    }

    public ArrayList<FightEntity> getAllEntities() {
        return entitiesList;
    }
    public ArrayList<Opponent> getAllOpponents() {
        ArrayList<Opponent> opponents = new ArrayList<>();
        for(int i = 1; i< entitiesList.size(); i++){
            opponents.add((Opponent) entitiesList.get(i));
        }
        return opponents;
    }
    public Opponent getOpponent(int position){
        if (position> entitiesList.size()-1 || position<=0){
            throw new IllegalArgumentException("Position must be above 0 and below the number of entities");
        }
        return (Opponent) entitiesList.get(position);
    }

    public AbstractAction.ActionType getOpponentMove(int position) {
        return getOpponent(position).getNextActionType();
    }

    public void makeOpponentDie(int position) {
        entitiesList.remove(position);
    }

    public boolean isFightOver() {
        int opponentDead = 0;
        for (int i = 1; i <= opponentAmount(); i++) {
            if (getOpponent(i).isDead()) {
                opponentDead++;
            }
        }

        if (opponentDead == opponentAmount()) {
            return true;
        } else return getPlayer().isDead();
    }
}
