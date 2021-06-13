package main.Room;


import main.Fight.*;
import main.Fight.Pattern.CultistPattern;
import main.Fight.Pattern.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RoomBuilder {
    private static RoomBuilder instance = null;
    private static final HashMap<roomType,ArrayList<Opponent>> typeMap = new HashMap<>();
    private static final HashMap<String,Opponent> nameMap = new HashMap<>();
    private RoomBuilder() {
    }
    private static void initMonster(){
        //Initialisation monstres
        Pattern pat = new CultistPattern();
        Opponent cultist = new Opponent("Cultist", 47, pat);
        typePut(roomType.FIGHT,cultist);
        nameMap.put("Cultist",cultist);
    }

    private static void typePut(roomType type,Opponent opponent){
        ArrayList<Opponent> opponentsArray = new ArrayList<>();
        opponentsArray.add(opponent);
        if (typeMap.putIfAbsent(type,opponentsArray)==null){
            typeMap.get(type).add(opponent);
        }
    }

    public static RoomBuilder getRoomBuilder() {
        if (instance == null) {
            instance = new RoomBuilder();
            initMonster();
        }
        return instance;
    }

    private Opponent randomEnnemy(roomType type){
        Random random = new Random();
        ArrayList<Opponent> a = typeMap.get(type);
        return a.get(random.nextInt(a.size()));
    }

    private FightRoom buildFight(roomType type, PlayerAvatar playerAvatar){
        ArrayList<FightEntity> arrayOpponents= new ArrayList<>();
        arrayOpponents.add(randomEnnemy(type));
        return new FightRoom(playerAvatar,arrayOpponents);
    }

    public Room createRoom(roomType type, PlayerAvatar playerAvatar) {
        switch (type){
            case FIGHT, BOSS, ELITE -> {
                return buildFight(type, playerAvatar);
            }
            case SHOP, REST -> {
                return null;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
    public enum roomType{
        FIGHT,SHOP,ELITE,BOSS,REST
    }

}
