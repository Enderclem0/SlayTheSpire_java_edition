package main.Card.Strategies;

import main.Card.Card;
import main.Fight.Debuff;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.ArrayList;

public record DoubleBlockStrategy() implements CardStrategy {

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        fightRoom.getPlayer().addBlock(fightRoom.getPlayer().getBlock());
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
