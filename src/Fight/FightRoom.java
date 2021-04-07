package SlayTheSpire.src.Fight;

import java.util.ArrayList;
import java.util.Objects;

public class FightRoom {
    private final ArrayList<FightEntity> entitiesList;
    private Potion potion;
    private int nbTurns=0;

    public FightRoom(ArrayList<FightEntity> entities, Potion potion) {
        Objects.requireNonNull(entities);
        Objects.requireNonNull(potion);
        this.entitiesList = entities;
        this.potion = potion;
    }

    public void playOpponentTurn() {
        for (int i = 1; i< entitiesList.size(); i++){
            // entitiesList.get(i).
        }
    }
    public FightEntity getPlayer(){
        return entitiesList.get(0);
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
    public FightEntity getOpponent(int position){
        if (position> entitiesList.size()-1 || position<=0){
            throw new IllegalArgumentException("Position must be above 0 and below the number of entities");
        }
        return entitiesList.get(position);
    }

    public void getOpponentMove() {
        // ...
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