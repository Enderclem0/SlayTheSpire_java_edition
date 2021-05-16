package main;
import main.Card.*;
import main.Card.Strategies.*;
import main.Fight.*;
import main.Room.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private final Scanner scanner = new Scanner(System.in);
    private static UI instance=null;
    private UI(){ }
    public static UI getUI() {
        if (instance==null){
            instance=new UI();
        }
        return instance;
    }

    private static void gameOver() {
    }
    public void startRoom(Room room){
    }
    public int getUserInput(String textToDisplay){
        System.out.println(textToDisplay);
        return scanner.nextInt();
    }
    public static void main(String[] args) throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        // Initialisation personnage
        PlayerAvatar p1 = new PlayerAvatar(80, 3, 80, 3);
        ArrayList<CardStrategy> strat = new ArrayList<>();
        strat.add(new SimpleAttackStrategy(6));
        Card strike = new Card(strat,1,"Strike", Card.Type.ATTACK,"Deal 6 damage");
        ArrayList<CardStrategy> strat2 = new ArrayList<>();
        strat2.add(new BlockStrategy(5));
        Card defend = new Card(strat2,1,"Defend", Card.Type.SKILL,"Gain 5 Block");
        ArrayList<CardStrategy> strat3 = new ArrayList<>();
        strat3.add(new SimpleAttackStrategy(8));
        Card bash = new Card(strat3,2,"Bash", Card.Type.ATTACK,"Deal 8 damage.\n Apply vulnerable 2");
        strat3.add(new VulnerableStrategy(5));
        p1.AddCard(strike,5);
        p1.AddCard(defend,4);
        p1.AddCard(bash);

        // Initialisation de la fight room
        ArrayList<FightEntity> entities = new ArrayList<>();
        FightRoom fightRoom = new FightRoom(p1,entities);

        // Boucle de jeu
        if (fightRoom.playRoom()){
            display.displayWin();
        }
        else {
            display.displayLose();
        }
    }
}
