package SlayTheSpire.src;

import java.util.HashMap;
import java.util.Map;

public abstract class Mapbuilder {
    private static Mapbuilder instance = null;
    private final HashMap<String,Integer> roomNumber = (HashMap<String, Integer>) Map.ofEntries(
            Map.entry("FightRoom",4),
            Map.entry(""),

    )

    private Mapbuilder(){}
    public static Mapbuilder getMapBuilder(){
        if(instance==null){
            instance = new Mapbuilder();
        }
        return instance;
    }
    public abstract GameMap createMap(int nbrRoom, int lvl);

}