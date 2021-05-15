package main;

import main.Card.*;
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

        // Initialiser Player et Opponent
        Display display = TextDisplay.getDisplay();
        PlayerAvatar p1 = new PlayerAvatar(20, 20, 20, 20);
        ArrayList<Action> possibleAction = new ArrayList<>();
        possibleAction.add(new ActionAttack(5));
        possibleAction.add(new ActionBlock(5));
        ArrayList<CardStrategy> strat = new ArrayList<>();
        strat.add(new AllAttackStrategy(6));
        Card allAttack = new Card(strat,3,"AllAttack", Card.Type.ATTACK,25,"Attack all ennemies.");
        ArrayList<CardStrategy> strat2 = new ArrayList<>();
        strat2.add(new BlockStrategy(3));
        strat2.add(new SimpleAttackStrategy(3));
        Card blockAttack = new Card(strat2,2,"BlockAttack", Card.Type.ATTACK,10,"Block then attack for 3");
        p1.AddCard(blockAttack);
        p1.AddCard(allAttack);
        Opponent o1 = new Opponent("Dwarf", possibleAction, 12);
        Potion potion1 = new Potion("Elixir", Potion.Rarity.COMMON, "Heal 10hp");

        // Initialisation de la fight room
        ArrayList<FightEntity> entities = new ArrayList<>();
        entities.add(p1);
        entities.add(o1);
        FightRoom fightRoom = new FightRoom(entities,potion1);


        // Boucle de jeu
        if (fightRoom.playRoom()){
            display.displayWin();
        }
        else {
            display.displayLose();
        }
    }
}
