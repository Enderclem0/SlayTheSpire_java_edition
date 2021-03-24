package main;

public abstract class Mapbuilder {
    private static Mapbuilder instance = null;
    private Mapbuilder(){}
    public static Mapbuilder getMapBuilder(){
        if(instance==null){
            instance = new Mapbuilder();
        }
        return instance;
    }
    public abstract Map createMap(int nbrRoom, int lvl);

}
