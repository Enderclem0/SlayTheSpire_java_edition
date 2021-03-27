package main.Fight;

import main.Card.Card;
import main.Player;

import java.util.ArrayList;

public class PlayerAvatar extends Player implements FightEntity {
    private ArrayList<Card> hand;

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax, ArrayList<Card> hand) {
        super(hp, energy, hpMax, energyMax);
        this.hand = hand;
    }

    @Override
    public boolean takeDamage(int dmg) {
        return super.damageHp(dmg);
    }
}
