package main.Card;

public class Card {
    private int energyCost;
    private String name;
    private static String[] type = {"Attack"," Skill","Power","Curse","Status"}
    private int typeNum;
    private int cost;
    public Card(int energyCost, String name,int typeNum,int cost) {
        this.energyCost = energyCost;
        this.name = name;
        this.typeNum = typeNum;

     }
}
