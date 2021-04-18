package main.Card;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();
    public int draw(CardPile pile,int amount){
        for (int i = 0; i < amount; i++) {
            if (pile.isEmpty() || cards.size()>=10){
                return amount-i;
            }
            cards.add(pile.pop());
        }
        return 0;
    }
    public boolean removeCard(Card card){
        return cards.remove(card);
    }
    public int getSize(){
        return cards.size();
    }
    public Card getCard(int pos){
        return cards.get(pos);
    }
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (Card card : cards) {
            ret.append(card.toString()).append("\n");
        }
        return ret.toString();
    }
}
