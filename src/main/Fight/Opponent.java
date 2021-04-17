package main.Fight;

import java.util.ArrayList;

public class Opponent implements FightEntity {
    private final String name;
    private final ArrayList<Action> possibleAction;
    private int hp;
    public Opponent(String name, ArrayList<Action> possibleAction, int hp){
        this.name = name;
        this.possibleAction = possibleAction;
        this.hp = hp;
    }

    @Override
    public void takeDamage(int dmg) {
        hp-=dmg;
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }
}