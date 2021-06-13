package main;

import main.Card.Hand;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.Player;
import main.Fight.PlayerAvatar;

import java.util.ArrayList;

public class ScreenDisplay implements Display {
    private static ScreenDisplay instance = null;
    private ScreenDisplay(){
    }

    public static ScreenDisplay getDisplay() {
        if (instance==null){
            instance = new ScreenDisplay();
        }
        return instance;
    }


    @Override
    public void displayFight(FightRoom fightRoom) {

    }

    @Override
    public void displayUI() {

    }

    @Override
    public void displayPlayerAvatar(PlayerAvatar playerAvatar) {

    }

    // @Override
    /*public String displayPlayerAvatar(PlayerAvatar playerAvatar) {
        String texte = "";
        texte += "Joueur 1:\n";
        texte += "Health: "+playerAvatar.hp+"/"+playerAvatar.hpMax+"\r\n";
        texte += "Block: "+playerAvatar.getBlock()+"/"+playerAvatar.hpMax+"\n";
        texte += "Energy:"+playerAvatar.energyMax+"/"+playerAvatar.energyMax+"\n";
        return texte;
    }*/

    @Override
    public void displayPlayer(Player player) {

    }

    @Override
    public void displayOpponents(ArrayList<Opponent> ennemies, FightRoom fightRoom) {

    }

    @Override
    public void displayOpponentBuff(Opponent opponent) {

    }

    @Override
    public void displayPlayerBuff(PlayerAvatar playerAvatar) {

    }

    public void displayOpponents(ArrayList<Opponent> ennemies) {

    }

    @Override
    public void displayHand(Hand hand) {

    }

    @Override
    public void displayAction(Opponent action, FightRoom fightRoom) {

    }

    public void displayAction(Opponent action) {

    }

    @Override
    public void displayWin() {

    }

    @Override
    public void displayLose() {

    }

    @Override
    public void displayDiscard(PlayerAvatar playerAvatar) {

    }

    @Override
    public void displayDraw(PlayerAvatar playerAvatar) {

    }

    @Override
    public void displayText(String text) {

    }
}
