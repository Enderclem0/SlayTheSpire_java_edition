package main.Fight.Pattern;

import main.Fight.Buff;
import main.Fight.FightRoom;
import main.Fight.Opponent;

import java.util.Random;

public class JawWormPattern implements Pattern {
    private final Random random = new Random();
    private int rand;
    private int chompCount;
    private int thrashCount;
    private int bellowCount;

    @Override
    public void perform(FightRoom fightRoom, Opponent me) {
        if (fightRoom.getTurn() == 0) {
            chompCount = 1;
            thrashCount = 0;
            bellowCount = 0;
            me.damage(11, fightRoom.getPlayer());
        } else {
            if (rand < 45) {
                me.addBlock(6);
                me.addBuff(Buff.STRENGHT, 3);
                chompCount = 0;
                thrashCount = 0;
                bellowCount += 1;
            } else if (rand < 75) {
                me.addBlock(5);
                me.damage(7, fightRoom.getPlayer());
                chompCount = 0;
                thrashCount += 1;
                bellowCount = 0;
            } else {
                me.damage(11, fightRoom.getPlayer());
                chompCount += 1;
                thrashCount = 0;
                bellowCount = 0;
            }
        }
    }

    @Override
    public ActionType getNextActionType(FightRoom fightRoom) {
        if (fightRoom.getTurn() == 0) {
            return ActionType.ATTACK;
        } else {
            rand = random.nextInt(100) + 1;
            boolean valid = true;
            while (!valid) {
                if (rand < 45 && bellowCount == 1) {
                    valid = false;
                    rand = random.nextInt(100) + 1;
                } else if (rand < 75 && thrashCount == 2) {
                    valid = false;
                    rand = random.nextInt(100) + 1;
                } else if (chompCount == 2) {
                    valid = false;
                    rand = random.nextInt(100) + 1;
                } else valid = true;
            }
            if (rand < 45) {
                return ActionType.ATTACK;
            } else if (rand < 75) {
                return ActionType.ATTACK;
            } else {
                return ActionType.BUFF;
            }
        }
    }
}
