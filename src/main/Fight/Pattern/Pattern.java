package main.Fight.Pattern;

import main.Fight.FightRoom;
import main.Fight.Opponent;

public interface Pattern {
    void perform(FightRoom fightRoom, Opponent me);

    ActionType getNextActionType(FightRoom fightRoom);
}
