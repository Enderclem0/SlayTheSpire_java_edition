package main;

import main.Fight.Player;
import main.Room.Room;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Room> map;
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
