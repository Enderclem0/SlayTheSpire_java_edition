package main;

import main.Card.Hand;
import main.Fight.*;

import java.util.ArrayList;
import java.util.Map;

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
        displayOpponents(fightRoom.getAllOpponents(),fightRoom);
    }

    @Override
    public void displayUI() {

    }

    @Override
    public void displayPlayerAvatar(PlayerAvatar playerAvatar) {
        System.out.println("Joueur 1:");
        System.out.println("Health: "+playerAvatar.getHp()+"/"+playerAvatar.getHpMax());
        System.out.println("Block: "+playerAvatar.getBlock());
        System.out.println("Energy:"+playerAvatar.getEnergy()+"/"+playerAvatar.getEnergyMax());
        displayPlayerBuff(playerAvatar);
    }

    @Override
    public void displayPlayer(Player player) {

    }

    @Override
    public void displayOpponents(ArrayList<Opponent> ennemies,FightRoom fightRoom) {
        for (Opponent enemy : ennemies) {
            System.out.println(enemy+" next action:"+enemy.getNextActionType(fightRoom)+"\n");
            displayOpponentBuff(enemy);
        }
    }

    @Override
    public void displayOpponentBuff(Opponent opponent) {
        StringBuilder ret = new StringBuilder();
        ret.append("Buffs:\n");
        for (Map.Entry<Buff, Integer> buffIntegerEntry : opponent.getBuffs().entrySet()) {
            ret.append(buffIntegerEntry.getKey()).append(":").append(buffIntegerEntry.getValue()).append("\n");
        }
        System.out.println(ret);
        ret = new StringBuilder();
        ret.append("Debuff:\n");
        for (Map.Entry<Debuff, Integer> debuffIntegerEntry : opponent.getDebuffs().entrySet()) {
            ret.append(debuffIntegerEntry.getKey()).append(":").append(debuffIntegerEntry.getValue()).append("\n");
        }
        System.out.println(ret);
    }

    @Override
    public void displayPlayerBuff(PlayerAvatar playerAvatar) {
        StringBuilder ret = new StringBuilder();
        ret.append("Buffs:\n");
        for (Map.Entry<Buff, Integer> buffIntegerEntry : playerAvatar.getBuffs().entrySet()) {
            ret.append(buffIntegerEntry.getKey()).append(":").append(buffIntegerEntry.getValue()).append("\n");
        }
        System.out.println(ret);
        ret = new StringBuilder();
        ret.append("Debuffs:\n");
        for (Map.Entry<Debuff, Integer> debuffIntegerEntry : playerAvatar.getDebuffs().entrySet()) {
            ret.append(debuffIntegerEntry.getKey()).append(":").append(debuffIntegerEntry.getValue()).append("\n");
        }
        System.out.println(ret);
    }

    @Override
    public void displayHand(Hand hand) {
        System.out.println("Hand: "+hand);
    }

    @Override
    public void displayAction(Opponent opponent,FightRoom fightRoom) {
        System.out.println(opponent+" utilise "+opponent.getNextActionType(fightRoom));
    }

    @Override
    public void displayWin() {
        System.out.println("Vous avez gagné");
    }

    @Override
    public void displayLose() {
        System.out.println("Vous avez perdu");
    }

    @Override
    public void displayDiscard(PlayerAvatar playerAvatar) {
        System.out.println(playerAvatar.getDiscard());
    }

    @Override
    public void displayDraw(PlayerAvatar playerAvatar) {
        System.out.println(playerAvatar.getDraw());
    }

    @Override
    public void displayText(String text) {
        System.out.println(text);
    }
}
