package main.Card;


public abstract class CardBuilder {
    private static CardBuilder instance = null;
    private int unlockNumber;
    private static enum Color{
        COLORLESS,CURSE,IRONCLAD
    }
    private CardBuilder(){}
    public CardBuilder getCardBuilder(){
        if (instance==null){
            instance = new CardBuilder();
        }
        return instance;
    }
    public abstract Card createCard(String name, String type,int energyCost);

}
