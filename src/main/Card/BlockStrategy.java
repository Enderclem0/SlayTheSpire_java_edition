package main.Card;

import main.Fight.FightRoom;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

public class BlockStrategy implements CardStrategy{
    private int block;
    @Override
    public void playStrat(FightRoom fightRoom, ArrayList<Object> chosen) {
        PlayerAvatar player = fightRoom.getPlayer();
        player.addBlock(block);
    }

    public BlockStrategy(int block){
        this.block=block;
    }
    @Override
    public Card.targetType getTarget() {
        return null;
    }
}
