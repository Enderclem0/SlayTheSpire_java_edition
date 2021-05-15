package main;

import main.Card.Hand;
import main.Fight.Action;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

public class TextDisplay implements Display {
    private static TextDisplay instance = null;
    private TextDisplay(){
    }

    public static TextDisplay getDisplay() {
        if (instance==null){
            instance = new TextDisplay();
        }
        return instance;
    }

    @Override
    public void displayFight(FightRoom fightRoom) {
        PlayerAvatar playerAvatar = fightRoom.getPlayer();
        displayPlayerAvatar(playerAvatar);
        displayHand(playerAvatar.getHand());
        displayOpponents(fightRoom.getAllOpponents());
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
    public void displayOpponents(ArrayList<Opponent> ennemies) {
        for (Opponent enemy : ennemies) {
            System.out.println(enemy+" next action:"+enemy.getNextActionType()+"\n");
        }
    }

    @Override
    public void displayHand(Hand hand) {
        System.out.println("Hand: "+hand);
    }

    @Override
    public void displayAction(Opponent opponent) {
        System.out.println(opponent+" utilise "+opponent.getNextActionType());
    }

    @Override
    public void displayWin() {
        System.out.println("Vous avez gagné");
    }

    @Override
    public void displayLose() {
        System.out.println("Vous avez perdu");
    }
}
