package main.Room;


import main.Fight.FightEntity;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.Pattern.CultistPattern;
import main.Fight.Pattern.JawWormPattern;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RoomBuilder {
    private static RoomBuilder instance = null;
    private static final HashMap<roomType,ArrayList<Opponent>> typeMap = new HashMap<>();
    private static final HashMap<String,Opponent> nameMap = new HashMap<>();
    private RoomBuilder() {
    }
    private static void initMonster() {
        //Initialisation monstres
        Opponent cultist = new Opponent("Cultist", 47, new CultistPattern());
        typePut(roomType.FIGHT, cultist);
        nameMap.put("Cultist", cultist);
        Opponent jawWorm = new Opponent("Jaw Worm", 42, new JawWormPattern());
        typePut(roomType.FIGHT, jawWorm);
        nameMap.put("JawWorm", jawWorm);
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
        return new Opponent(a.get(random.nextInt(a.size())));
    }

    private FightRoom buildFight(roomType type, PlayerAvatar playerAvatar) {
        ArrayList<FightEntity> arrayOpponents = new ArrayList<>();
        arrayOpponents.add(randomEnnemy(type));
        return new FightRoom(playerAvatar, arrayOpponents);
    }

    public Opponent getOpponent(String monster) {
        return new Opponent(nameMap.getOrDefault(monster, null));
    }

    public Room createRoom(roomType type, PlayerAvatar playerAvatar) {
        switch (type) {
            case FIGHT, BOSS, ELITE -> {
                return buildFight(type, playerAvatar);
            }
            case SHOP, REST -> {
                return null;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    public ArrayList<Opponent> getAllOpponents() {
        ArrayList<Opponent> ret = new ArrayList<>();
        for (Map.Entry<String, Opponent> stringCardEntry : nameMap.entrySet()) {
            ret.add(stringCardEntry.getValue());
        }
        return ret;
    }

    public enum roomType {
        FIGHT, SHOP, ELITE, BOSS, REST
    }

}
