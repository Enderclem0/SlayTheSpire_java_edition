package main.Card;


import main.Card.Strategies.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardBuilder {
    private static CardBuilder instance = null;
    private static final HashMap<Color, ArrayList<Card>> colorMap = new HashMap<>();
    private static final HashMap<String, Card> cardMap = new HashMap<>();
    private static void initCard(){
        ArrayList<CardStrategy> strat = new ArrayList<>();
        strat.add(new SimpleAttackStrategy(6));
        buildCard("Strike",1,new ArrayList<>(strat),Card.Type.ATTACK,"Deal 6 damage",Color.IRONCLAD);
        strat.clear();
        strat.add(new BlockStrategy(5));
        buildCard("Defend",1,new ArrayList<>(strat),Card.Type.SKILL,"Gain 5 block",Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(8));
        strat.add(new VulnerableStrategy(2));
        buildCard("Bash",2,new ArrayList<>(strat), Card.Type.ATTACK,"Deal 3 damage. Apply 2 Vulnerable",Color.IRONCLAD);
        strat.clear();
        strat.add(new SpecialAttackStrategy(Properties.BLOCK));
        buildCard("BodySlam",1,new ArrayList<>(strat), Card.Type.ATTACK,"Deal damage equal to your Block",Color.IRONCLAD);
        strat.clear();
        strat.add(new AllAttackStrategy(8));
        buildCard("Cleave",1,new ArrayList<>(strat),Card.Type.ATTACK,"Deal 8 damage to all enemies",Color.IRONCLAD);
        strat.clear();
        strat.add(new MultiplierAttackStrategy(14,3));
        buildCard("HeavyBlade",2,new ArrayList<>(strat),Card.Type.ATTACK,"Deal 14 damage. Strength affects Heavy Blade 3 times",Color.IRONCLAD);
        strat.clear();
        strat.add(new BlockStrategy(5));
        strat.add(new SimpleAttackStrategy(5));
        buildCard("IronWave",2,new ArrayList<>(strat), Card.Type.ATTACK,"Gain 5 Block. Deal 5 damage.",Color.IRONCLAD);
        strat.clear();
        strat.add(new EnergyStrategy(2));
        strat.add(new LoseHpStrategy(3));
        buildCard("Bloodletting",0,new ArrayList<>(strat), Card.Type.SKILL,"Lose 3 HP. Gain 2 energy.",Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(7));
        strat.add(new GainHpStrategy(2));
        buildCard("Bite", 1, new ArrayList<>(strat), Card.Type.ATTACK, "Deal 7 damages. Heal 2HP.", Color.IRONCLAD);
        strat.clear();
        strat.add(new WeakStrategy(2));
        buildCard("Blind", 0, new ArrayList<>(strat), Card.Type.SKILL, "Apply 2 Weak.", Color.IRONCLAD);
        strat.clear();
        strat.add(new AllAttackStrategy(6));
        buildCard("DramaticEntrance", 0, new ArrayList<>(strat), Card.Type.ATTACK, "Innate. Deal 6 damage to ALL enemies.", Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(4));
        buildCard("Shiv", 0, new ArrayList<>(strat), Card.Type.ATTACK, "Deal 4 damage.", Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(6));
        buildCard("SwiftStrike", 0, new ArrayList<>(strat), Card.Type.ATTACK, "Deal 6 damage.", Color.IRONCLAD);
        strat.clear();
        strat.add(new VulnerableStrategy(2));
        buildCard("Trip", 0, new ArrayList<>(strat), Card.Type.SKILL, "Apply 2 Vulnerable.", Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(32));
        buildCard("Bludgeon", 3, new ArrayList<>(strat), Card.Type.ATTACK, "Deal 32 damage.", Color.IRONCLAD);
        strat.clear();
        strat.add(new SimpleAttackStrategy(12));
        strat.add(new WeakStrategy(2));
        buildCard("Clothesline", 2, new ArrayList<>(strat), Card.Type.ATTACK, "Deal 12 damage. Apply 2 Weak.", Color.IRONCLAD);
        strat.clear();
        strat.add(new DoubleBlockStrategy());
        buildCard("Entrench", 2, new ArrayList<>(strat), Card.Type.SKILL, "Double your Block.", Color.IRONCLAD);
        strat.clear();
        strat.add(new LoseHpStrategy(3));
        strat.add(new SimpleAttackStrategy(14));
        buildCard("Hemokinesis", 0, new ArrayList<>(strat), Card.Type.ATTACK, "Lose 3 HP. Deal 14 damage.", Color.IRONCLAD);
        strat.clear();
        strat.add(new BlockStrategy(30));
        buildCard("Impervious", 2, new ArrayList<>(strat), Card.Type.SKILL, "Gain 30 Block.", Color.IRONCLAD);
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
        System.out.println(a);
        return a.get(random.nextInt(a.size()));
    }

    public Card getCard(String name) {
        return cardMap.getOrDefault(name, null);
    }

    public ArrayList<Card> getAllCards() {
        ArrayList<Card> ret = new ArrayList<>();
        for (Map.Entry<String, Card> stringCardEntry : cardMap.entrySet()) {
            ret.add(stringCardEntry.getValue());
        }
        return ret;
    }

    public enum Color {
        COLORLESS, CURSE, IRONCLAD,
    }

}
