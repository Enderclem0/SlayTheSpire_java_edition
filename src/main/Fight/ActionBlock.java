package main.Fight;

import main.Fight.Action;

public class ActionBlock extends AbstractAction implements Action {
    private int amount;

    public ActionBlock(int amount) {
        super(ActionType.Shield);
        this.amount=amount;
    }

    @Override
    public void perform(Object object) {
        Opponent opponent = (Opponent) object;
        opponent.addBlock(amount);
    }
}
