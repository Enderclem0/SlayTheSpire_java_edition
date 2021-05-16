package main.Fight;

import main.Card.Card;
import main.Card.CardPile;

import java.util.Objects;

public class Player {
    protected int hp;
    protected int energy;
    protected int hpMax;
    protected int energyMax;
    private int gold;
    private int currentStage=0;
    protected final CardPile deck = new CardPile("Deck");
    public Player(int hp, int energy, int hpMax, int energyMax) {
        this.hp = hp;
        this.energy = energy;
        this.hpMax = hpMax;
        this.energyMax = energyMax;
    }
    public int getHp() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getEnergyMax() {
        return energyMax;
    }
    public void damageHp(int dmg){
        hp-=dmg;
    }
    public void healHp(int heal){
        hp+=heal;
        if (hp>hpMax){
            hp=hpMax;
        }
    }
    public void AddCard(Card card){
        Objects.requireNonNull(card);
        deck.push(card);
    }
    public void AddCard(Card card,int amount){
        for (int i = 0; i < amount; i++) {
            AddCard(card);
        }
    }
    public void progress(){
        currentStage++;
    }
}
