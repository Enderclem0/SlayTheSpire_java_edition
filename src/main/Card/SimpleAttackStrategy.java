package main.Card;

import main.Fight.Opponent;

public class SimpleAttackStrategy implements CardStrategy {
    int dmg;
    @Override
    public void playStrat(Object obj) {
        Opponent enemy = (Opponent) obj;
        enemy.takeDamage(dmg);
    }

    @Override
    public Card.targetType getTarget() {
        return Card.targetType.ENNEMY;
    }
}
