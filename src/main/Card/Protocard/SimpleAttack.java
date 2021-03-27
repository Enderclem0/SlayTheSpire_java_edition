package main.Card.Protocard;

import main.Card.ProtoCard;
import main.Fight.FightEntity;
import main.Fight.FightRoom;
import main.Fight.Target;

import java.util.ArrayList;
import java.util.Objects;

public class SimpleAttack implements ProtoCard {
    private int damage;
    private final Target target;
    public SimpleAttack(int damage,Target target){
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
    }
    private void attack(FightEntity entity){

    }
}
