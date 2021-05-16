package main.Card.Strategies;

import main.Card.Card;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.ArrayList;

public record AllAttackStrategy(int dmg) implements CardStrategy {

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        ArrayList<Opponent> ennemies = fightRoom.getAllOpponents();
        for (Opponent enemy : ennemies) {
            fightRoom.getPlayer().damage(dmg, enemy);
        }
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
