package main;

public abstract class Mapbuilder {
    private static Mapbuilder instance = null;
    private Mapbuilder(){}
    private static Mapbuilder getMapBuilder(){
        if(instance==null){
            instance = new Mapbuilder();
        }
        return instance;
    }
    public abstract Map createMap();
}
