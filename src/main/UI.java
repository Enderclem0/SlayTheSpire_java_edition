package main;

import main.Card.Card;
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
        // Initialisation personnage
        PlayerAvatar p1 = new PlayerAvatar(80, 3, 80, 3);
        ArrayList<CardStrategy> strat = new ArrayList<>();
        strat.add(new SimpleAttackStrategy(6));
        Card strike = new Card(strat, 1, "Strike", Card.Type.ATTACK, "Deal 6 damage");
        ArrayList<CardStrategy> strat2 = new ArrayList<>();
        strat2.add(new BlockStrategy(5));
        Card defend = new Card(strat2, 1, "Defend", Card.Type.SKILL, "Gain 5 Block");
        ArrayList<CardStrategy> strat3 = new ArrayList<>();
        strat3.add(new SimpleAttackStrategy(8));
        strat3.add(new VulnerableStrategy(2));
        Card bash = new Card(strat3, 2, "Bash", Card.Type.ATTACK, "Deal 8 damage, apply vulnerable 2");
        p1.AddCard(strike, 5);
        p1.AddCard(defend, 4);
        p1.AddCard(bash);
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
