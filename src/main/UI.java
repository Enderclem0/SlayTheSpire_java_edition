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
        Mapbuilder mapbuilder = Mapbuilder.getMapBuilder();
        CardBuilder cardBuilder = CardBuilder.getCardBuilder();
        PlayerAvatar playerAvatar = new PlayerAvatar(80, 3, 80, 3);
        GameMap map = mapbuilder.createMap(playerAvatar);
        playerAvatar.AddCard(cardBuilder.getCard("Strike"), 5);
        playerAvatar.AddCard(cardBuilder.getCard("Defend"), 4);
        playerAvatar.AddCard(cardBuilder.getCard("Bash"));
        map.playMap(playerAvatar);
    }
    public int getUserInput(String textToDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToDisplay);
        return scanner.nextInt();
    }
}
