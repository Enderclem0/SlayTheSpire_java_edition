package main.Card;

public abstract class CardBuilder {
    private static CardBuilder instance = null;
    private static String[] rarity = {"Common","Uncommon","Rare"};
    private static String[] type = {"Attack"," Skill","Power","Curse","Status"};
    private int unlockNumber;
    private CardBuilder(){}
    public CardBuilder getCardBuilder(){
        if (instance==null){
            instance = new CardBuilder();
        }
        return instance;
    }
    public abstract Card createCard(String name, String type,int energyCost);

}
