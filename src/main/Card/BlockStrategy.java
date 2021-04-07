package main.Card;

import main.Fight.PlayerAvatar;

public class BlockStrategy implements CardStrategy{
    int block;
    @Override
    public void playStrat(Object obj) {
        PlayerAvatar player = (PlayerAvatar) obj;
        player.addBlock(block);
    }

    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
