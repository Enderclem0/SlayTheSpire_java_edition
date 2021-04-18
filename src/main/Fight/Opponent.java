package main.Fight;

import java.util.ArrayList;
import java.util.Random;

public class Opponent implements FightEntity {
    private final String name;
    private final ArrayList<Action> possibleAction;
    private AbstractAction.ActionType nextAction;
    private int hp;
    private int block = 0;
    public Opponent(String name, ArrayList<Action> possibleAction, int hp){
        this.name = name;
        this.possibleAction = possibleAction;
        this.hp = hp;
    }
    public AbstractAction.ActionType getNextAction(){
        return nextAction;
    }
    public void randomizeNextAction(){
        Random random = new Random();

        nextAction = possibleAction.get(random.nextInt(possibleAction.size()-1)).getType();
    }
    @Override
    public void takeDamage(int dmg) {
        hp-=dmg;
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    public void addBlock(int shield){
        block+=shield;
    }
    public void resetBlock(){
        block = 0;
    }
}