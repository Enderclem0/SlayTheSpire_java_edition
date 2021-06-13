package main.Fight.Pattern;

import main.Fight.Buff;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.Random;

public class JawWormPattern implements Pattern {
    @Override
    public void perform(FightRoom fightRoom, Opponent me) {
        if (fightRoom.getTurn() == 0) {
            int chompCount = 0;
            me.damage(11,fightRoom.getPlayer());
        } else {
            Random random = new Random();

        }
    }

    @Override
    public ActionType getNextActionType(FightRoom fightRoom) {
        if (fightRoom.getTurn() == 0) {
            return ActionType.ATTACK;
        } else {
            return ActionType.ATTACK;
        }
    }
}
