package main;

import main.Card.CardPile;
import main.Card.Protocard.ProtoCard;

import java.util.Objects;

public class Player {
    private int hp;
    private int energy;
    private int hpMax;
    private int energyMax;
    private int gold;
    private int currentStage=0;
    private CardPile deck = new CardPile();
    public Player(int hp, int energy, int hpMax, int energyMax) {
        this.hp = hp;
        this.energy = energy;
        this.hpMax = hpMax;
        this.energyMax = energyMax;
    }
    public boolean damageHp(int dmg){
        hp-=dmg;
        return hp <= 0;
    }
    public void healHp(int heal){
        hp+=heal;
        if (hp>hpMax){
            hp=hpMax;
        }
    }
    public void AddCard(ProtoCard card){
        Objects.requireNonNull(card);
        deck.push(card);
    }
    public void progress(){
        currentStage++;
    }
}
