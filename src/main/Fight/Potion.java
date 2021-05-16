package main.Fight;

import java.util.Objects;

public class Potion {
    Rarity rarity;
    private final String name;
    private final String effect;
    public Potion(String name, Rarity rarity, String effect) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(rarity);
        Objects.requireNonNull(effect);
        this.name = name;
        this.rarity = rarity;
        this.effect = effect;
    }

    public enum Rarity {
        COMMON, UNCOMMON
    }
}
