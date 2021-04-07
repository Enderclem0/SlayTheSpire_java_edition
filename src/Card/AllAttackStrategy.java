package SlayTheSpire.src.Card;

import SlayTheSpire.src.Fight.FightRoom;
import SlayTheSpire.src.Fight.Opponent;

import java.util.ArrayList;

public class AllAttackStrategy implements CardStrategy {
    int dmg;
    @Override
    public void playStrat(Object obj) {
        FightRoom fight = (FightRoom) obj;
        ArrayList<Opponent> ennemies = fight.getAllOpponents();
        for (Opponent ennemy : ennemies) {
            ennemy.takeDamage(dmg);
        }
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}