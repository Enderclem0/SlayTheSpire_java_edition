package main;

import main.Fight.PlayerAvatar;

public interface Display {
    TextDisplay getDisplay();
    void displayUI();
    void displayPlayerAvatar(PlayerAvatar playerAvatar);
    void displayPlayer(Player player);
    void displayOpponents();
    void displayCards();
}
