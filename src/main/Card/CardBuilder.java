package main.Card;


public class CardBuilder {
    private static CardBuilder instance = null;
    private int unlockNumber;

    private CardBuilder() {
    }

    public CardBuilder getCardBuilder() {
        if (instance == null) {
            instance = new CardBuilder();
        }
        return instance;
    }

    public Card createCard(String name, String type, int energyCost) {
        return null;
    }

    private enum Color {
        COLORLESS, CURSE, IRONCLAD
    }

}
