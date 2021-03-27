package main.Card.Protocard;

public abstract class AbstractCard {
    int energyCost;
    String name;
    enum Type{
        ATTACK,SKILL,POWER,STATUS,CURSE
    }
    Type type;
    int cost;
    AbstractCard(int energyCost,String name,Type type){
        this.energyCost=energyCost;
        this.name=name;
        this.type=type;
    }
    boolean isUseable(int energy){
        return energy>=energyCost;
    }
}
