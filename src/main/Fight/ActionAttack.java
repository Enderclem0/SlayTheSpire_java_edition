package main.Fight;

import main.Player;

public class ActionAttack extends AbstractAction implements Action{
    private final int amount;
    public ActionAttack(ActionType type, int amount) {
        super(type);
        this.amount = amount;
    }

    @Override
    public void perform(Object object) {
        PlayerAvatar player = (PlayerAvatar) object;
        player.damageHp(amount);
    }
}
