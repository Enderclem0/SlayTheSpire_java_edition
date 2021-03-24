package main.Fight;

public class PlayerAvatar {
    private ArrayList<Card> hand;
    private int armor;
    private int hp;
    private int energy;
    private int hpMax;
    private int energyMax;

    public PlayerAvatar(ArrayList<Card> hand, int armor, int hp, int energy, int hpMax, int energyMax) {
        this.hand = hand;
        this.armor = armor;
        this.hp = hp;
        this.energy = energy;
        this.hpMax = hpMax;
        this.energyMax = energyMax;
    }

}
