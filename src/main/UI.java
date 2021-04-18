package main;

import main.Fight.*;
import main.Room.Room;

import java.util.ArrayList;

public class UI {
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

    public static void main(String[] args) {
        // Initialiser Player et Opponent
        PlayerAvatar p1 = new PlayerAvatar(20, 20, 20, 20);
        ArrayList<Action> possibleAction = new ArrayList<>();
        possibleAction.add(new ActionAttack(5));
        possibleAction.add(new ActionBlock(5));
        Opponent o1 = new Opponent("Dwarf", possibleAction, 12);
        Potion potion1 = new Potion("Elixir", Potion.Rarity.COMMON, "Heal 10hp");

        // Initialisation de la fight room
        ArrayList<FightEntity> entities = new ArrayList<>();
        entities.add(p1);
        entities.add(o1);
        FightRoom fightRoom = new FightRoom(entities,potion1);



        // Boucle de jeu
        while (!(fightRoom.isFightOver())) {
            // ...
        }
    }
}
