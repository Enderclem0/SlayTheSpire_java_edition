package main;

import main.Card.Card;
import main.Card.Hand;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.Player;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

public interface Display {
    void displayFight(FightRoom fightRoom);

    void displayCard(Card card);

    void displayUI();

    void displayPlayerAvatar(PlayerAvatar playerAvatar);

    void displayPlayer(Player player);

    void displayOpponents(ArrayList<Opponent> ennemies, FightRoom fightRoom);

    void displayOpponentBuff(Opponent opponent);

    void displayPlayerBuff(PlayerAvatar playerAvatar);

    void displayHand(Hand hand);

    void displayAction(Opponent action, FightRoom fightRoom);

    void displayWin();

    void displayLose();

    void displayDiscard(PlayerAvatar playerAvatar);

    void displayDraw(PlayerAvatar playerAvatar);

    void displayText(String text);
}
