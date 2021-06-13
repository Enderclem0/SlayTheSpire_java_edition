package main;


import main.Room.RoomBuilder;

public class Mapbuilder {
    private static Mapbuilder instance = null;
    private Mapbuilder() {
    }

    public static Mapbuilder getMapBuilder() {
        if (instance == null) {
            instance = new Mapbuilder();
        }
        return instance;
    }

    public GameMap createMap() {
        RoomBuilder roomBuilder = RoomBuilder.getRoomBuilder();
        GameMap game = new GameMap();

        return game;
    }

}
