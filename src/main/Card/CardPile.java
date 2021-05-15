package main.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CardPile{
    private final ArrayList<Card> pile = new ArrayList<>();
    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public void push(Card item) {
        Objects.requireNonNull(item);
        pile.add(item);
    }

    public Card peek() {
        return pile.get(-1);
    }

    public Card pop() {
        return pile.remove(pile.size()-1);
    }
    public void shuffle(){
        Collections.shuffle(pile);
    }
}
