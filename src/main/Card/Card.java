package main.Card;

import main.Card.Strategies.CardStrategy;
import main.Fight.FightRoom;

import java.util.ArrayList;

public record Card(ArrayList<CardStrategy> strategies, int energyCost,
                   String name, main.Card.Card.Type type, String description) {


    public boolean isUsable(int energy) {
        return energy >= energyCost;
    }

    public ArrayList<targetType> getTargets() {
        ArrayList<targetType> targetList = new ArrayList<>();
        for (CardStrategy strategy : strategies) {
            targetList.add(strategy.getTarget());
        }
        return targetList;
    }

    public void playCard(FightRoom fightRoom, ArrayList<Object> target) {
        for (CardStrategy strategy : strategies) {
            strategy.playStrat(fightRoom, target);
        }
        fightRoom.getPlayer().useEnergy(energyCost);
    }

    @Override
    public String toString() {
        return name + " cost: " + energyCost + ", Type: " + type + " " + description;
    }

    public enum targetType {
        ENNEMY, CARD_DISCARD, CARD_HAND, CARD_DRAWPILE
    }

    public enum Type {
        ATTACK, SKILL, POWER, STATUS, CURSE
    }
}
