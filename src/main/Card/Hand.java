package main.Card;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    public int draw(CardPile pile, int amount) {
        for (int i = 0; i < amount; i++) {
            if (pile.isEmpty() || cards.size() >= 10) {
                return amount - i;
            }
            cards.add(pile.pop());
        }
        return 0;
    }
    public void addCard(Card card) {
        if (cards.size()<10) {
            cards.add(card);
        }
        else {
            System.out.println("Too much Cards, maximum is 10");
        }
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public int getSize() {
        return cards.size();
    }

    public Card getCard(int pos) {
        return cards.get(pos);
    }

    public Card pop() {
        return cards.remove(cards.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Card card : cards) {
            ret.append(card.toString()).append("\n");
        }
        return ret.toString();
    }
}
