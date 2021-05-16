package main.Fight.Pattern;

import main.Fight.Buff;
import main.Fight.FightRoom;
import main.Fight.Opponent;

public class CultistPattern implements Pattern {
    @Override
    public void perform(FightRoom fightRoom, Opponent me) {
        if (fightRoom.getTurn()==0){
            me.addBuff(Buff.STRENGHT,3);
        }
        else {
            me.damage(6,fightRoom.getPlayer());
        }
    }
    @Override
    public ActionType getNextActionType(FightRoom fightRoom) {
        if (fightRoom.getTurn()==0){
            return ActionType.BUFF;
        }
        else{
            return ActionType.ATTACK;
        }
    }
}
