package main.Card;


import main.Card.Strategies.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CardBuilder {
    private static CardBuilder instance = null;
    private int unlockNumber;
    private static final HashMap<Color, ArrayList<Card>> colorMap = new HashMap<>();
    private static final HashMap<String, Card> cardMap = new HashMap<>();
    private static void initCard(){
        ArrayList<CardStrategy> strat = new ArrayList<>();
        strat.add(new SimpleAttackStrategy(6));
        buildCard("Strike",1,strat,Card.Type.ATTACK,"Deal 6 damage",Color.IRONCLAD);
        strat.clear();
        strat.add(new BlockStrategy(5));
        buildCard("Defend",1,strat,Card.Type.SKILL,"Gain 5 block",Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(8));
        strat.add(new VulnerableStrategy(2));
        buildCard("Bash",2,strat, Card.Type.ATTACK,"Deal 3 damage. Apply 2 Vulnerable",Color.IRONCLAD);
        strat.clear();
        strat.add(new SpecialAttackStrategy(Properties.BLOCK));
        buildCard("Body Slam",1,strat, Card.Type.ATTACK,"Deal damage equal to your Block",Color.IRONCLAD);
        strat.clear();
        strat.add(new AllAttackStrategy(8));
        buildCard("Cleave",1,strat,Card.Type.ATTACK,"Deal 8 damage to all enemies",Color.IRONCLAD);
        strat.clear();
        strat.add(new MultiplierAttackStrategy(14,3));
        buildCard("Heavy Blade",2,strat,Card.Type.ATTACK,"Deal 14 damage. Strength affects Heavy Blade 3 times",Color.IRONCLAD);
        strat.clear();
        strat.add(new BlockStrategy(5));
        strat.add(new SimpleAttackStrategy(5));
        buildCard("Iron Wave",2,strat, Card.Type.ATTACK,"Gain 5 Block. Deal 5 damage.",Color.IRONCLAD);
        strat.clear();
        strat.add(new EnergyStrategy(2));
        strat.add(new LoseHpStrategy(3));
        buildCard("Bloodletting",0,strat, Card.Type.SKILL,"Lose 3 HP. Gain 2 energy.",Color.IRONCLAD);
    }



    private CardBuilder() {
    }
    private static void buildCard(String name, int energyCost, ArrayList<CardStrategy> strat, Card.Type type, String description, Color color){
        Card card = new Card(strat,energyCost,name,type,description);
        cardMap.put(name,card);
        colorPut(card,color);
    }
    private static void colorPut(Card card, Color color){
        ArrayList<Card> cardArray = new ArrayList<>();
        cardArray.add(card);
        if (colorMap.putIfAbsent(color,cardArray)==null){
            colorMap.get(color).add(card);
        }
    }
    public static CardBuilder getCardBuilder() {
        if (instance == null) {
            instance = new CardBuilder();
            initCard();
        }
        return instance;
    }

    public Card createCard(Color color) {
        Random random = new Random();
        ArrayList<Card> a = colorMap.get(color);
        return a.get(random.nextInt(a.size()));
    }

    public Card getCard(String name){
        return cardMap.get(name);
    }

    private enum Color {
        COLORLESS, CURSE, IRONCLAD,
    }

}
