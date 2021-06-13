package main.Room;

import main.Fight.Player;

public interface Room {
    boolean playRoom(Player player) throws InterruptedException;
}
