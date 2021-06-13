package main;

import main.Card.CardBuilder;
import main.Fight.Player;
import main.Fight.PlayerAvatar;

import java.util.Scanner;

public class UI {
    private static UI instance = null;

    private UI() {
    }

    public static UI getUI() {
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }
    public static void main(String[] args) throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        // Initialisation personnage et cartes
        PlayerAvatar p1 = new PlayerAvatar(80, 3, 80, 3);
        Mapbuilder mapbuilder = Mapbuilder.getMapBuilder();
        CardBuilder cardBuilder = CardBuilder.getCardBuilder();
        GameMap map = new GameMap();
        p1.AddCard(cardBuilder.getCard("Strike"), 5);
        p1.AddCard(cardBuilder.getCard("Defend"), 4);
        p1.AddCard(cardBuilder.getCard("Bash"));
        map.playMap(new PlayerAvatar(p1));
    }
    public int getUserInput(String textToDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToDisplay);
        return scanner.nextInt();
    }
}
