package main.Card.Strategies;

import main.Card.Card;
import main.Fight.FightRoom;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

public record BlockStrategy(int block) implements CardStrategy {

    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        PlayerAvatar player = fightRoom.getPlayer();
        player.addBlock(block);
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
