package main;

import java.util.HashMap;
import java.util.Map;

public abstract class Mapbuilder {
    private static Mapbuilder instance = null;
    private final HashMap<String,Integer> roomNumber = (HashMap<String, Integer>) Map.ofEntries(
            Map.entry("FightRoom",4)
    );

    private Mapbuilder(){}
    public static Mapbuilder getMapBuilder(){
        if(instance==null){
            instance = new Mapbuilder() {
                @Override
                public GameMap createMap(int nbrRoom, int lvl) {
                    return null;
                }
            };
        }
        return instance;
    }
    public GameMap createMap(int nbrRoom, int lvl){
        return new GameMap();
    }

}
