package main.Card.Protocard;

abstract class AbstractCard {
    int energyCost;
    String name;
    static enum Type{
        ATTACK,SKILL,POWER,STATUS,CURSE
    }
    Type type;
    int cost;
    AbstractCard(int energyCost,String name,Type type){
        this.energyCost=energyCost;
        this.name=name;
        this.type=type;
    }
}
