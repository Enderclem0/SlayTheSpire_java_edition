package main.Card.Strategies;

import main.Card.Card;
import main.Fight.Debuff;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.ArrayList;

public record WeakStrategy(int numberOfTurn) implements CardStrategy {

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        Opponent opponent = (Opponent) chosen.get(0);
        opponent.setDebuff(Debuff.WEAK, numberOfTurn);
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
