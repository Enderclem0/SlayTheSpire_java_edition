package main.Fight;

import main.Card.Card;
import main.Card.CardPile;
import main.Card.Hand;
import main.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class PlayerAvatar extends Player implements FightEntity {
    private final Hand hand = new Hand();
    private final CardPile discard = new CardPile("Discard");
    private final CardPile draw = this.deck;
    private final int currentEnergy;
    private final HashMap<Debuff,Integer> debuff = new HashMap<>();
    private int block;

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax) {
        super(hp, energy, hpMax, energyMax);
        this.currentEnergy = energyMax;
        this.block=0;
        for (Debuff value : Debuff.values()) {
            debuff.put(value,0);
        }
    }
    @Override
    public void takeDamage(int dmg) {
        int rest;
        block -= dmg;
        if (block<0){
            rest=-block;
            block=0;
        }
        else {rest=dmg;}
        damageHp(rest);
    }
    public void draw(int amount){
        int drawEmpty = hand.draw(draw,amount);
        if(!(drawEmpty==0)){
            while (!discard.isEmpty()){
                draw.push(discard.pop());
            }
            draw.shuffle();
            hand.draw(draw,drawEmpty);
        }
    }
    public Card getFromDraw(int position){
        Card card = draw.draw(position);
        draw.shuffle();
        return card;
    }
    public void useEnergy(int amount){
        if(amount<=energy) {
            energy -= amount;
        }
    }
    public Hand getHand(){
        return hand;
    }
    public Card getCard(int num){
        return hand.getCard(num);
    }
    public int getNumberOfCard(){
        return hand.getSize();
    }
    public void addBlock(int shield){
        block+=shield;
    }
    public void resetEnergy(){
        energy = energyMax;
    }
    public void resetBlock(){
        block = 0;
    }
    public boolean isDead() {
        return hp <= 0;
    }
    public void discardHand(){
        while(hand.getSize()>0){
            discard.push(hand.pop());
        }
    }
    public boolean isCardPlayable(Card card){
        return card.isUsable(currentEnergy);
    }
    public CardPile getDraw(){
        return draw;
    }
    public CardPile getDiscard() {
        return discard;
    }
    public void setDebuff(Debuff effect,int amount){
        debuff.replace(effect,amount);
    }
    public void debuffTurn(){
        for (Debuff value : Debuff.values()) {
            debuff.compute(value,(k,v)->(Objects.requireNonNull(v)>0)?v-1:v);
        }

    }
    public int getBlock() {
        return block;
    }
}