package main;

import main.Room.Room;

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
}
