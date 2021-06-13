package main;

import main.Room.Room;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Room> map;
    public GameMap() {
    }
    public void addRoom(Room room){
        map.add(room);
    }
    public void playMap() throws InterruptedException {
        for (Room room : map) {
            room.playRoom();
        }
    }
}
