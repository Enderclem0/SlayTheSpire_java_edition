package main.Card;

import java.util.ArrayList;

public class Card {
    private final ArrayList<targetType> targets;
    int energyCost;
    String name;
    Type type;
    int cost;

    Card(ArrayList<targetType> targets, int energyCost, String name, Type type) {
        this.targets = targets;
        this.energyCost = energyCost;
        this.name = name;
        this.type = type;
    }


    boolean isUseable(int energy) {
        return energy >= energyCost;
    }

    public static enum targetType {
        ENNEMY, CARD_DISCARD, CARD_HAND, CARD_DRAWPILE
    }

    enum Type {
        ATTACK, SKILL, POWER, STATUS, CURSE
    }
}
