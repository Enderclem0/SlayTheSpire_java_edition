package main.Card;

import java.util.ArrayList;

public class Card {
    private final ArrayList<CardStrategy> strategies;
    private final int energyCost;
    private final String name;
    private final Type type;

    Card(ArrayList<CardStrategy> strategies, int energyCost, String name, Type type, int cost) {
        this.strategies = strategies;
        this.energyCost = energyCost;
        this.name = name;
        this.type = type;
    }


    boolean isUsable(int energy) {
        return energy >= energyCost;
    }

    public ArrayList<targetType> getTargets(){
        ArrayList<targetType> targetList = new ArrayList<targetType>();
        for (CardStrategy strategy : strategies) {
            targetList.add(strategy.getTarget());
        }
        return targetList;
    }
    public static enum targetType {
        ENNEMY, CARD_DISCARD, CARD_HAND, CARD_DRAWPILE
    }
    public void playCard(Object object){
        for (CardStrategy strategy : strategies) {
            strategy.playStrat(object);
        }
    }
    enum Type {
        ATTACK, SKILL, POWER, STATUS, CURSE
    }
}
