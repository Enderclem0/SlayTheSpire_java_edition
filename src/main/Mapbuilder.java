package main;


import main.Fight.PlayerAvatar;
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

    public GameMap createMap(PlayerAvatar playerAvatar) {
        RoomBuilder roomBuilder = RoomBuilder.getRoomBuilder();
        GameMap game = new GameMap();
        game.addRoom(roomBuilder.createRoom(RoomBuilder.roomType.FIGHT, playerAvatar));
        game.addRoom(roomBuilder.createRoom(RoomBuilder.roomType.FIGHT, playerAvatar));
        game.addRoom(roomBuilder.createRoom(RoomBuilder.roomType.FIGHT, playerAvatar));
        game.addRoom(roomBuilder.createRoom(RoomBuilder.roomType.FIGHT, playerAvatar));
        return game;
    }

}
