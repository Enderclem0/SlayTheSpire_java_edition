package main;

import main.Card.Card;
import main.Card.CardBuilder;
import main.Card.Strategies.BlockStrategy;
import main.Card.Strategies.CardStrategy;
import main.Card.Strategies.SimpleAttackStrategy;
import main.Card.Strategies.VulnerableStrategy;
import main.Fight.FightEntity;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.Pattern.CultistPattern;
import main.Fight.Pattern.Pattern;
import main.Fight.PlayerAvatar;
import main.Room.Room;

import java.util.ArrayList;
import java.util.Random;
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
    private static void gameOver() {
    }

    public static void main(String[] args) throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        // Initialisation personnage et cartes
        PlayerAvatar p1 = new PlayerAvatar(80, 3, 80, 3);
        CardBuilder cardBuilder = CardBuilder.getCardBuilder();
        cardBuilder.initCard();
        p1.AddCard(cardBuilder.getCard("Strike"), 5);
        p1.AddCard(cardBuilder.getCard("Defend"), 4);
        p1.AddCard(cardBuilder.getCard("Bash"));
        //Initialisation monstres
        Pattern cultPat = new CultistPattern();
        Random random = new Random();
        Opponent cultist = new Opponent("Cultist", 47 + random.nextInt(6), cultPat);
        // Initialisation de la fight room
        ArrayList<FightEntity> ennemies = new ArrayList<>();
        ennemies.add(cultist);
        FightRoom fightRoom = new FightRoom(p1, ennemies);

        if (fightRoom.playRoom()) {
            display.displayWin();
        } else {
            display.displayLose();
        }
    }

    public void startRoom(Room room) {
    }

    public int getUserInput(String textToDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToDisplay);
        return scanner.nextInt();
    }
}
