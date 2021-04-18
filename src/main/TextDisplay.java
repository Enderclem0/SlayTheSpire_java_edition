package main;

import main.Card.Hand;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

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
    }

    @Override
    public void displayPlayer(Player player) {

    }

    @Override
    public void displayOpponents(FightRoom fightRoom) {
        ArrayList<Opponent> ennemies = fightRoom.getAllOpponents();
        for (Opponent ennemy : ennemies) {
            System.out.println(ennemy+" next action:"+ennemy.getNextActionType()+"\n");
        }
    }

    @Override
    public void displayHand(Hand hand) {
        System.out.println("Hand: "+hand);
    }
}
