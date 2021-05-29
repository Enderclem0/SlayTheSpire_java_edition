package main.Card.Strategies;

import main.Card.Card;
import main.Card.Properties;
import main.Fight.FightRoom;

import java.util.ArrayList;

public record SpecialAttackStrategy(Properties property)implements CardStrategy{

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        int dmg;
        if (property == Properties.BLOCK) {
            dmg = fightRoom.getPlayer().getBlock();
        } else {
            throw new IllegalStateException("Unexpected value: " + property);
        }
        SimpleAttackStrategy strat = new SimpleAttackStrategy(dmg);
        strat.playStrat(fightRoom,chosen);
    }

    @Override
    public Card.targetType getTarget() {
        return Card.targetType.ENNEMY;
    }
}
