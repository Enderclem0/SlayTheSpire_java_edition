package main.Card;

public class Card {
    private int EnergyCost;
    private String name;

    public Card(int energyCost, String name, String type, Effect effect) {
        EnergyCost = energyCost;
        this.name = name;
        this.effect = effect;
    }
}
