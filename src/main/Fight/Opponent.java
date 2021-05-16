package main.Fight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Opponent implements FightEntity {
    private final String name;
    private final ArrayList<Action> possibleAction;
    private Action nextAction;
    private int hp;
    private int block = 0;
    private final HashMap<Debuff,Integer> debuff = new HashMap<>();
    public Opponent(String name, ArrayList<Action> possibleAction, int hp){
        this.name = name;
        this.possibleAction = possibleAction;
        this.hp = hp;
        for (Debuff value : Debuff.values()) {
            debuff.put(value,0);
        }
        randomizeNextAction();
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
        if (debuff.get(Debuff.VULNERABLE) > 0) {
            dmg *= 1.5;
        }
            int rest;
            block -= dmg;
            if (block < 0) {
                rest = -block;
                block = 0;
            } else {
                rest = dmg;
            }
            hp -= (rest);
        }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }
    public void setDebuff(Debuff effect,int amount){
        debuff.replace(effect,amount);
    }
    public void debuffTurn(){
        for (Debuff value : Debuff.values()) {
            debuff.compute(value,(k,v)->(Objects.requireNonNull(v) >0)?v-1:v);
        }

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