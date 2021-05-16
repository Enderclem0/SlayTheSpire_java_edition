package main.Card.Strategies;

import main.Card.Card;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.ArrayList;

public class AllAttackStrategy implements CardStrategy {
    int dmg;
    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        ArrayList<Opponent> ennemies = fightRoom.getAllOpponents();
        for (Opponent ennemy : ennemies) {
            ennemy.takeDamage(dmg);
        }
    }
    public AllAttackStrategy(int dmg){
        this.dmg=dmg;
    }
    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
