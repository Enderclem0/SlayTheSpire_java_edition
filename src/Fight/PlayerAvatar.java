package SlayTheSpire.src.Fight;

import SlayTheSpire.src.Card.Card;
import SlayTheSpire.src.Player;

import java.util.ArrayList;

public class PlayerAvatar extends Player implements FightEntity {
    private final ArrayList<Card> hand = new ArrayList<>();

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