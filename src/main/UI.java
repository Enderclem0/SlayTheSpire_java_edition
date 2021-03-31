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

    public void gameOver() {
    }
    public void startRoom(Room room){
    }

    public static void main(String[] args) {
        // Initialiser Player et Opponent
        // Initialiser le deck du Player
        PlayerAvatar p1 = new PlayerAvatar(20, 20, 20, 20);
        Opponent o1 = new Opponent("Dwarf", 7, 25);

        ArrayList<FightEntity> entities = new ArrayList<FightEntity>();
        entities.add(p1);
        entities.add(o1);
        FightRoom fightRoom = new FightRoom(entities, );

        // Player attack --> Opponent
        // Opponent attack -- > Player
        while(true) {



            if (p1.isDead()){
                gameOver();
            } else if (o1.isDead()) {
                System.out.println("");
            }
        }
    }
}
