package main;

import main.Fight.PlayerAvatar;

public class TextDisplay implements Display {
    private static TextDisplay instance = null;
    private TextDisplay(){
    }

    @Override
    public TextDisplay getDisplay() {
        if (instance==null){
            instance = new TextDisplay();
        }
        return instance;
    }

    @Override
    public void displayUI() {

    }

    @Override
    public void displayPlayerAvatar(PlayerAvatar playerAvatar) {
        System.out.println("Joueur 1:");
        System.out.println("Health: "+playerAvatar.hp+"/"+playerAvatar.hpMax);
        System.out.println("Energy:"+playerAvatar.energyMax+"/"+playerAvatar.energyMax);
        System.out.println("Hand:");
    }

    @Override
    public void displayPlayer(Player player) {

    }

    @Override
    public void displayOpponents() {

    }

    @Override
    public void displayCards() {

    }
}
