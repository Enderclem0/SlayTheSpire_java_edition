package main.Card.Strategies;

import main.Card.Card;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.ArrayList;

public class SimpleAttackStrategy implements CardStrategy {
    int dmg;
    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        Opponent enemy = (Opponent) chosen.get(0);
        enemy.takeDamage(dmg);
    }
    public SimpleAttackStrategy(int dmg){
        this.dmg=dmg;
    }
    @Override
    public Card.targetType getTarget() {
        return Card.targetType.ENNEMY;
    }
}
