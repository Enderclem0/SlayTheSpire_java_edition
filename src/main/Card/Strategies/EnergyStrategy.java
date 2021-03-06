package main.Card.Strategies;

import main.Card.Card;
import main.Fight.FightRoom;

import java.util.ArrayList;

public record EnergyStrategy(int amount) implements CardStrategy {

    @Override
    public void playStrat(FightRoom fightRoom,ArrayList<Object> chosen) {
        fightRoom.getPlayer().addEnergy(amount);
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
