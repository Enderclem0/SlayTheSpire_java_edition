package main.Card;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();
    public int Draw(CardPile pile,int amount){
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
}
