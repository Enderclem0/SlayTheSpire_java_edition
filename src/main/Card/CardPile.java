package main.Card;

import main.Card.Protocard.ProtoCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CardPile{
    private final ArrayList<ProtoCard> pile = new ArrayList<>();
    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public void push(ProtoCard item) {
        Objects.requireNonNull(item);
        pile.add(item);
    }

    public ProtoCard peek() {
        return pile.get(-1);
    }

    public ProtoCard pop() {
        return pile.remove(-1);
    }
    public void shuffle(){
        Collections.shuffle(pile);
    }
}
