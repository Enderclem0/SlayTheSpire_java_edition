package main.Card;

import main.Card.Protocard.ProtoCard;

import java.util.HashSet;

public abstract class CardBuilder {
    private static CardBuilder instance = null;
    private static HashSet<ProtoCard> Basic;
    private static HashSet<ProtoCard> Common;
    private static HashSet<ProtoCard> Uncommon;
    private static HashSet<ProtoCard> Rare;
    private static HashSet<ProtoCard> Special;
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
