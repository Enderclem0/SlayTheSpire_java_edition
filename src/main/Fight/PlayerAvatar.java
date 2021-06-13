package main.Fight;

import main.Card.Card;
import main.Card.CardPile;
import main.Card.Hand;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class PlayerAvatar extends Player implements FightEntity {
    private final Hand hand = new Hand();
    private final CardPile discard = new CardPile("Discard");
    private final CardPile draw = this.deck;
    private final HashMap<Debuff, Integer> debuff = new HashMap<>();
    private final HashMap<Buff, Integer> buff = new HashMap<>();
    private int block;

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax) {
        super(hp, energy, hpMax, energyMax);
        this.energy = energyMax;
        this.block = 0;
        for (Debuff value : Debuff.values()) {
            debuff.put(value, 0);
        }
        for (Buff value : Buff.values()) {
            buff.put(value, 0);
        }
    }

    public PlayerAvatar(PlayerAvatar p1) {
        super(p1.hp, p1.energyMax, p1.hpMax, p1.energyMax);
        this.block = 0;
    }

    public PlayerAvatar(Player player){
        super(player.hp, player.energyMax,player.hpMax, player.energyMax);
    }

    @Override
    public void takeDamage(int dmg) {
        int rest;
        if (debuff.get(Debuff.VULNERABLE) > 0) {
            dmg *= 1.5;
        }
        block -= dmg;
        if (block < 0) {
            rest = -block;
            block = 0;
        } else {
            rest = dmg;
        }
        damageHp(rest);
    }

    @Override
    public void damage(int dmg, FightEntity fightEntity) {
        fightEntity.takeDamage((int) (Math.ceil(dmg + buff.get(Buff.STRENGHT))/(0.25*(debuff.get(Debuff.WEAK)>0?1:0))));
    }
    public void damage(int dmg, FightEntity fightEntity,int multiplier) {
        fightEntity.takeDamage((int) (Math.ceil(dmg + buff.get(Buff.STRENGHT)*3)/(0.25*(debuff.get(Debuff.WEAK)>0?1:0))));
    }

    public void draw(int amount) {
        int drawEmpty = hand.draw(draw, amount);
        if (!(drawEmpty == 0)) {
            while (!discard.isEmpty()) {
                draw.push(discard.pop());
            }
            draw.shuffle();
            hand.draw(draw, drawEmpty);
        }
    }

    public Card getFromDraw(int position) {
        Card card = draw.draw(position);
        draw.shuffle();
        return card;
    }

    public void useEnergy(int amount) {
        if (amount <= energy) {
            energy -= amount;
        }
    }
    public void addEnergy(int amount) {
        energy+=amount;
    }

    public HashMap<Buff, Integer> getBuffs() {
        return new HashMap<>(buff.entrySet().stream().filter(map -> map.getValue() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public HashMap<Debuff, Integer> getDebuffs() {
        return new HashMap<>(debuff.entrySet().stream().filter(x -> x.getValue() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public Hand getHand() {
        return hand;
    }

    public Card getCard(int num) {
        return hand.getCard(num);
    }

    public void addBlock(int shield) {
        block += shield;
    }

    public void resetEnergy() {
        energy = energyMax;
    }

    public void resetBlock() {
        block = 0;
    }

    public boolean isDead() {
        return hp <= 0;
    }
    public void loseHp(int amount){
        damageHp(amount);
    }

    public void discardHand() {
        while (hand.getSize() > 0) {
            discard.push(hand.pop());
        }
    }

    public boolean isCardPlayable(Card card) {
        return card.isUsable(energy);
    }

    public CardPile getDraw() {
        return draw;
    }

    public CardPile getDiscard() {
        return discard;
    }

    public void setDebuff(Debuff effect, int amount) {
        debuff.replace(effect, amount);
    }

    public void debuffTurn() {
        for (Debuff value : Debuff.values()) {
            debuff.compute(value, (k, v) -> (Objects.requireNonNull(v) > 0) ? v - 1 : v);
        }

    }

    public int getBlock() {
        return block;
    }
}