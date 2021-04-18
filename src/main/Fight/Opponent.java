package main.Fight;

import main.Player;

import java.util.ArrayList;
import java.util.Random;

public class Opponent implements FightEntity {
    private final String name;
    private final ArrayList<Action> possibleAction;
    private Action nextAction;
    private int hp;
    private int block = 0;
    public Opponent(String name, ArrayList<Action> possibleAction, int hp){
        this.name = name;
        this.possibleAction = possibleAction;
        this.hp = hp;
    }
    public AbstractAction.ActionType getNextActionType(){
        return nextAction.getType();
    }
    public void randomizeNextAction(){
        Random random = new Random();
        nextAction = possibleAction.get(random.nextInt(possibleAction.size()-1));
    }
    public void playNextAction(PlayerAvatar playerAvatar){
        switch (nextAction.getType()){
            case Buff, Shield -> nextAction.perform(this);
            case Damage, Debuff -> nextAction.perform(playerAvatar);
        }
    }
    @Override
    public void takeDamage(int dmg) {
        hp-=dmg;
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    @Override
    public String toString(){
        return name+" health: "+hp+" block: "+block;
    }

    public void addBlock(int shield){
        block+=shield;
    }
    public void resetBlock(){
        block = 0;
    }
}