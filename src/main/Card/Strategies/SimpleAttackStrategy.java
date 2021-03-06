package main.Card.Strategies;

import main.Card.Card;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.ArrayList;

public record SimpleAttackStrategy(int dmg) implements CardStrategy {

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        Opponent enemy = (Opponent) chosen.get(0);
        fightRoom.getPlayer().damage(dmg, enemy);
    }

    @Override
    public Card.targetType getTarget() {
        return Card.targetType.ENNEMY;
    }
}
