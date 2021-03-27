package main.Card.Protocard;

import main.Fight.FightEntity;
import main.Fight.FightRoom;
import main.Fight.Target;

import java.util.ArrayList;
import java.util.Objects;

public class SimpleAttack extends AbstractCard implements ProtoCard {
    private int damage;
    private final Target target;
    public SimpleAttack(int energyCost,String name,Type type,int damage,Target target){
        super();
        Objects.requireNonNull(target);
        this.damage=damage;
        this.target=target;
    }
    @Override
    public void effect(FightRoom fightRoom, int position) {
        ArrayList<FightEntity> targeted = new ArrayList<>();
        switch (target){
            case PLAYER -> targeted.add(fightRoom.getPlayer());
            case EVERYONE -> targeted=(fightRoom.getAllEntities());
            case OPPONENT -> targeted.add(fightRoom.getOpponent(position));
        }
        for (FightEntity entity:targeted) {
            entity.takeDamage(damage);
        }
    }
    private void attack(FightEntity entity){

    }
}
