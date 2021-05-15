package main.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CardPile{
    private final ArrayList<Card> pile = new ArrayList<>();
    private String name;

    public CardPile(String name) {
        this.name = Objects.requireNonNull(name);
    }
    public int getSize(){
        return pile.size();
    }
    public boolean isEmpty() {
        return pile.isEmpty();
    }
    public boolean isFull() {
        return false;
    }
    public Card draw(int position){
        return pile.remove(position);
    }
    public void push(Card item) {
        Objects.requireNonNull(item);
        pile.add(item);
    }
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append(name).append(":\n");
        for (Card card : pile) {
            ret.append(card.toString()).append("\n");
        }
        return ret.toString();
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
