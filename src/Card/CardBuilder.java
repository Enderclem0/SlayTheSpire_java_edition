package SlayTheSpire.src.Card;


public class CardBuilder {
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

    public Card createCard(String name, String type, int energyCost) {
        return null;
    }

}
