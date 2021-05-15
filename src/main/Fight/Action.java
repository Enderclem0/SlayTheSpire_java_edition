package main.Fight;

public interface Action {
    void perform(Object object);
    AbstractAction.ActionType getType();
}
