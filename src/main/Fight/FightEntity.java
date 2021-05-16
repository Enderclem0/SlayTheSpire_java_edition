package main.Fight;

public interface FightEntity {
    void takeDamage(int dmg);
    void damage(int dmg,FightEntity fightEntity);
    boolean isDead();
    void addBlock(int shield);
    void resetBlock();
}