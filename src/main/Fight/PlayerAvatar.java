package main.Fight;

import main.Card.Card;
import main.Player;

import java.util.ArrayList;

public class PlayerAvatar extends Player implements FightEntity {
    private final ArrayList<Card> hand = new ArrayList<>();

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax) {
        super(hp, energy, hpMax, energyMax);
    }
    public void drawHand(int num){

    }
    @Override
    public boolean takeDamage(int dmg) {
        return super.damageHp(dmg);
    }
}
