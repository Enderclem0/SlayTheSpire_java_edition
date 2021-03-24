package main.Card;

public class Card {
    private int energyCost;
    private String name;
    private static enum Type{
        ATTACK,SKILL,POWER,STATUS,CURSE
    }
    private Type type;
    private int cost;
    public Card(int energyCost, String name,Type type,int cost) {
        this.energyCost = energyCost;
        this.name = name;
        this.type = type;

     }
}
