package main.Fight;

public interface FightEntity {
    void takeDamage(int dmg);

    boolean isDead();
    void addBlock(int shield);
    void resetBlock();
}