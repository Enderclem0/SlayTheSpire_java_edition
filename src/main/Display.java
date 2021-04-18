package main;

import main.Card.Hand;
import main.Fight.FightRoom;
import main.Fight.PlayerAvatar;

public interface Display {
    TextDisplay getDisplay();
    void displayUI();
    void displayPlayerAvatar(PlayerAvatar playerAvatar);
    void displayPlayer(Player player);
    void displayOpponents(FightRoom fightRoom);
    void displayHand(Hand hand);
}
