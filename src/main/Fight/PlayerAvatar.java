package main.Fight;

import main.Card.Card;
import main.Card.CardPile;
import main.Card.Hand;
import main.Player;


public class PlayerAvatar extends Player implements FightEntity {
    private final Hand hand = new Hand();
    private final CardPile discard = new CardPile();
    private final CardPile draw = this.deck;
    private final int currentEnergy;
    private int block;

    public PlayerAvatar(int hp, int energy, int hpMax, int energyMax) {
        super(hp, energy, hpMax, energyMax);
        this.currentEnergy = energyMax;
        this.block=0;
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
    public void resetBlock(){
        block = 0;
    }
    public boolean isDead() {
        return hp <= 0;
    }
    public boolean isCardPlayable(Card card){
        return card.isUsable(currentEnergy);
    }
}