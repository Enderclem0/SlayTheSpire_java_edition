package SlayTheSpire.src.Card;

import SlayTheSpire.src.Fight.Opponent;

public class SimpleAttackStrategy implements CardStrategy {
    int dmg;
    @Override
    public void playStrat(Object obj) {
        Opponent ennemy = (Opponent) obj;
        ennemy.takeDamage(dmg);
    }

    @Override
    public Card.targetType getTarget() {
        return Card.targetType.ENNEMY;
    }
}
