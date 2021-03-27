package main.Fight;

public class Opponent implements FightEntity {
    private String name;
    private int hp;
    public Opponent(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    @Override
    public boolean takeDamage(int dmg) {
        hp-=dmg;
        return hp<=0;
    }
}
