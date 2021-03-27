package main.Fight;

import java.util.Objects;

public class Potion {
    private String name;
    private enum Rarity {
        COMMON, UNCOMMON
    }
    Rarity rarity;
    private String effect;

    public Potion(String name, Rarity rarity, String effect) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(rarity);
        Objects.requireNonNull(effect);
        this.name = name;
        this.rarity = rarity;
        this.effect = effect;
    }
}
