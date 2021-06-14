package main.Card.Strategies;

import main.Card.Card;
import main.Card.Pile;
import main.Fight.FightRoom;
import main.Fight.Player;

import java.util.ArrayList;

public record AddCardStrategy(Card card, Pile pile) implements CardStrategy{

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        switch (pile){
            case HAND -> fightRoom.getPlayer().getHand().addCard(card);
            case DISCARD -> {fightRoom.getPlayer().getDiscard().push(card);
                fightRoom.getPlayer().getDiscard().shuffle();
            }
            case DRAWPILE -> {fightRoom.getPlayer().getDraw().push(card);
                fightRoom.getPlayer().getDraw().shuffle();
            }
            case DECK -> {
                Player player = fightRoom.getPlayer();
                player.addCard(card);
            }
        }
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
