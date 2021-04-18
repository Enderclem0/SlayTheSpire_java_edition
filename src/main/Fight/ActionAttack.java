package main.Fight;

public class ActionAttack extends AbstractAction implements Action{
    private final int amount;
    public ActionAttack(int amount) {
        super(ActionType.Damage);
        this.amount = amount;
    }

    @Override
    public void perform(Object object) {
        PlayerAvatar player = (PlayerAvatar) object;
        player.damageHp(amount);
    }
}
