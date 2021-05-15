package main;

import main.Card.Hand;
import main.Fight.Action;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

public interface Display {
    void displayFight(FightRoom fightRoom);
    void displayUI();
    void displayPlayerAvatar(PlayerAvatar playerAvatar);
    void displayPlayer(Player player);
    void displayOpponents(ArrayList<Opponent> ennemies);
    void displayHand(Hand hand);
    void displayAction(Opponent action);
    void displayWin();
    void displayLose();
    void displayDiscard(PlayerAvatar playerAvatar);
    void displayDraw(PlayerAvatar playerAvatar);
    void displayText(String text);
}
