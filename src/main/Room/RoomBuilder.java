package main.Room;


import main.Fight.*;
import main.Fight.Pattern.CultistPattern;
import main.Fight.Pattern.Pattern;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomBuilder {
    private static RoomBuilder instance = null;
    private static final HashMap<roomType,Opponent> typeMap = new HashMap<>();
    private static final HashMap<String,Opponent> nameMap = new HashMap<>();
    private RoomBuilder() {
    }
    private static void initMonster(){
        //Initialisation monstres
        Pattern pat = new CultistPattern();
        Opponent cultist = new Opponent("Cultist", 47, pat);
        typeMap.put(roomType.FIGHT,cultist);
        nameMap.put("Cultist",cultist);
    }

    public static RoomBuilder getRoomBuilder() {
        if (instance == null) {
            instance = new RoomBuilder();
            initMonster();
        }
        return instance;
    }

    private FightRoom buildFight(PlayerAvatar player){
        ArrayList<FightEntity> arrayOpponents= new ArrayList<>();

        return new FightRoom(player,arrayOpponents);
    }

    public Room createRoom(roomType type) {
        switch (type){
            case FIGHT -> {
                return buildFight()
            }
            case SHOP -> {

            }
            case ELITE -> {

            }
            case BOSS -> {

            }
            case REST -> {

            }
        }
    }
    public enum roomType{
        FIGHT,SHOP,ELITE,BOSS,REST
    }

}
