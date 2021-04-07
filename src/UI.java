package SlayTheSpire.src;

import SlayTheSpire.src.Fight.*;
import SlayTheSpire.src.Room.Room;

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

    public void startRoom(Room room){
    }

    public static void main(String[] args) {
        // Initialiser Player et Opponent
        // Initialiser le deck du Player
        PlayerAvatar p1 = new PlayerAvatar(20, 20, 20, 20);
        Opponent o1 = new Opponent("Dwarf", 12);
        Potion potion1 = new Potion("Elixir", Potion.Rarity.COMMON, "Heal 10hp");

        // Initialisation de la fight room
        ArrayList<FightEntity> entities = new ArrayList<FightEntity>();
        entities.add(p1);
        entities.add(o1);
        FightRoom fightRoom = new FightRoom(entities,potion1);



        // Player attack --> Opponent
        // Opponent attack -- > Player
        while (!(fightRoom.isFightOver())) {
            // ...
        }
    }
}
