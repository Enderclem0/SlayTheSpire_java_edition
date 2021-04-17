package main.Fight;

public class AbstractAction {
    public AbstractAction(ActionType type) {
        this.type = type;
    }

    enum ActionType{
        Buff,Debuff,Damage,Shield
    };
    private final ActionType type;
    public String getType(){
        return type.toString();
    }
}
