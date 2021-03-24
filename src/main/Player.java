package main;

import main.Card.CardPile;

public class Player {
    private int hp;
    private int energy;
    private int hpMax;
    private int energyMax;
    private int gold;
    private int currentStage=0;
    private CardPile Deck = new CardPile();
    public Player(int hp, int energy, int hpMax, int energyMax) {
        this.hp = hp;
        this.energy = energy;
        this.hpMax = hpMax;
        this.energyMax = energyMax;
    }
    public void damageHp(int dmg){
        hp-=dmg;
        if (hp<=0){
            UI ui=UI.getUI();
            ui.gameOver();
        }
    }
    public void healHp(int heal){
        hp+=heal;
        if (hp>hpMax){
            hp=hpMax;
        }
    }
    public void progress(){
        currentStage++;
    }
}
