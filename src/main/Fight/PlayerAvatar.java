package main.Fight;

import main.Card.Protocard.ProtoCard;
import main.Player;

import java.util.ArrayList;

public class PlayerAvatar extends Player implements FightEntity {
    private final ArrayList<ProtoCard> hand = new ArrayList<>();

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax) {
        super(hp, energy, hpMax, energyMax);
    }
    public void drawHand(int num){

    }
    @Override
    public void takeDamage(int dmg) {
        damageHp(dmg);
    }

    public boolean isDead() {
        return hp <= 0;
    }
}