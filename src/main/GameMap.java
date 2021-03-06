package main;

import main.Fight.Player;
import main.Room.Room;

import java.util.ArrayList;

public class GameMap {
    private final ArrayList<Room> map = new ArrayList<>();
    public GameMap() {
    }
    public void addRoom(Room room){
        map.add(room);
    }
    public void playMap(Player player) throws InterruptedException {
        for (Room room : map) {
            room.playRoom(player);
        }
    }
}
