package main.Fight;

import main.Card.Hand;
import main.Player;

public class PlayerAvatar extends Player implements FightEntity {
    private final Hand hand = new Hand();
    private int currentEnergy;
    private int block;

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax) {
        super(hp, energy, hpMax, energyMax);
        this.currentEnergy = energyMax;
        this.block=0;
    }
    @Override
    public void takeDamage(int dmg) {
        int rest;
        block -= dmg;
        if (block<0){
            rest=-block;
            block=0;
        }
        else {rest=dmg;}
        damageHp(rest);
    }

    public boolean isDead() {
        return hp <= 0;
    }
}