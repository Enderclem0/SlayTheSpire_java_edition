package main.Fight;

import main.Fight.Pattern.Pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Opponent implements FightEntity {
    private final String name;
    private final HashMap<Debuff, Integer> debuff = new HashMap<>();
    private final HashMap<Buff, Integer> buff = new HashMap<>();
    private final Pattern pattern;
    private int hp;
    private int block = 0;

    public Opponent(String name, int hp, Pattern pattern) {
        this.name = name;
        this.hp = hp;
        this.pattern = pattern;
        for (Debuff value : Debuff.values()) {
            debuff.put(value, 0);
        }
        for (Buff value : Buff.values()) {
            buff.put(value, 0);
        }
    }

    public main.Fight.Pattern.ActionType getNextActionType(FightRoom fightRoom) {
        return pattern.getNextActionType(fightRoom);
    }

    public void playNextAction(FightRoom fightRoom) {
        pattern.perform(fightRoom, this);
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
    public void damage(int dmg, FightEntity fightEntity) {
        fightEntity.takeDamage((int) (Math.ceil(dmg + buff.get(Buff.STRENGHT))/(0.25*(debuff.get(Debuff.WEAK)>0?1:0))));
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    public void setDebuff(Debuff effect, int amount) {
        debuff.replace(effect, amount);
    }

    public void addBuff(Buff effect, int amount) {
        buff.compute(effect, (k, v) -> Objects.requireNonNull(v) + 1);
    }

    public HashMap<Buff, Integer> getBuffs() {
        return new HashMap<>(buff.entrySet().stream().filter(map -> map.getValue() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public HashMap<Debuff, Integer> getDebuffs() {
        return new HashMap<>(debuff.entrySet().stream().filter(x -> x.getValue() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public void debuffTurn() {
        for (Debuff value : Debuff.values()) {
            debuff.compute(value, (k, v) -> (Objects.requireNonNull(v) > 0) ? v - 1 : v);
        }

    }

    @Override
    public String toString() {
        return name + " health: " + hp + " block: " + block;
    }

    public void addBlock(int shield) {
        block += shield;
    }

    public void resetBlock() {
        block = 0;
    }

}