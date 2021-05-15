package main.Card;

import main.Fight.FightRoom;

import java.util.ArrayList;

public interface CardStrategy {
    void playStrat(FightRoom fightRoom, ArrayList<Object> chosen);
    Card.targetType getTarget();
}
