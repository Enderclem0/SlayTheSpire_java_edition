package main.Fight;

import main.Card.Card;
import main.Display;
import main.TextDisplay;
import main.UI;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FightRoom {
    private final ArrayList<FightEntity> entitiesList;
    private Potion potion;
    private int nbTurns = 0;

    public FightRoom(ArrayList<FightEntity> entities, Potion potion) {
        Objects.requireNonNull(entities);
        this.entitiesList = entities;
        this.potion = potion;
    }

    private Object getTarget(Card.targetType target) {
        boolean valid = false;
        UI ui = UI.getUI();
        Display display = TextDisplay.getDisplay();
        int chosen;
        switch (target) {
            case ENNEMY -> {
                do {
                    chosen = ui.getUserInput("Chose an opponent number");
                    if (chosen > 0 && chosen <= opponentAmount()) {
                        valid = true;
                    }
                } while (!valid);
                return getOpponent(chosen);
            }
            case CARD_DISCARD -> {
                do {
                    display.displayDiscard(getPlayer());
                    chosen = ui.getUserInput("Chose a card number from the discard");
                    if (chosen > 0 && chosen <= getPlayer().getDiscard().getSize()) {
                        valid = true;
                    }
                } while (!valid);
                return getPlayer().getDiscard().draw(chosen - 1);
            }
            case CARD_HAND -> {
                do {
                    chosen = ui.getUserInput("Chose a card in hand");
                    if (chosen > 0 && chosen <= getPlayer().getHand().getSize()) {
                        valid = true;
                    }
                } while (!valid);
                return getPlayer().getHand().getCard(chosen - 1);
            }
            case CARD_DRAWPILE -> {
                do {
                    display.displayDraw(getPlayer());
                    chosen = ui.getUserInput("Chose a card in drawpile");
                    if (chosen > 0 && chosen <= getPlayer().getDraw().getSize()) {
                        valid = true;
                    }
                } while (!valid);
                return getPlayer().getFromDraw(chosen);
            }
        }
        return null;
    }

    private void playCard(Card card) {
        ArrayList<Card.targetType> targets = card.getTargets();
        ArrayList<Object> chosenTarget = new ArrayList<>();
        for (Card.targetType target : targets) {
            if(target!=null){
                chosenTarget.add(getTarget(target));
            }
        }
        card.playCard(this, chosenTarget);
    }

    public void playPlayerTurn() {
        UI ui = UI.getUI();
        Display display = TextDisplay.getDisplay();
        PlayerAvatar playerAvatar = getPlayer();
        playerAvatar.draw((nbTurns == 0) ? 5 : 1);
        boolean skip = false;
        while (!skip) {
            display.displayHand(playerAvatar.getHand());
            int chosen = ui.getUserInput("Chose a card number or -1 to skip ");
            if (chosen > 0 && chosen <= playerAvatar.getHand().getSize()) {
                Card card = playerAvatar.getCard(chosen-1);
                if(playerAvatar.isCardPlayable(card)){
                    playCard(card);
                    display.displayFight(this);
                }
                else {
                    display.displayText("Card not playable");
                }
            } else {
                skip = true;
            }
        }
    }

    public Card choseCard(int numberOfCard) {
        UI ui = UI.getUI();
        int chosen;
        do {
            chosen = ui.getUserInput("Chose a card");
        }
        while (chosen < 0 || chosen > numberOfCard);
        return getPlayer().getCard(chosen);
    }

    public void playOpponentTurn() throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        ArrayList<Opponent> ennemies = getAllOpponents();
        for (Opponent enemy : ennemies) {
            display.displayAction(enemy);
            TimeUnit.SECONDS.sleep(1);
            enemy.playNextAction(getPlayer());
            enemy.randomizeNextAction();
        }
        nbTurns++;
    }

    public PlayerAvatar getPlayer() {
        return (PlayerAvatar) entitiesList.get(0);
    }

    public int opponentAmount() {
        return entitiesList.size() - 1;
    }

    public ArrayList<FightEntity> getAllEntities() {
        return entitiesList;
    }

    public ArrayList<Opponent> getAllOpponents() {
        ArrayList<Opponent> opponents = new ArrayList<>();
        for (int i = 1; i < entitiesList.size(); i++) {
            opponents.add((Opponent) entitiesList.get(i));
        }
        return opponents;
    }

    public Opponent getOpponent(int position) {
        if (position > entitiesList.size() - 1 || position <= 0) {
            throw new IllegalArgumentException("Position must be above 0 and below the number of entities here:"+position);
        }
        return (Opponent) entitiesList.get(position);
    }

    public AbstractAction.ActionType getOpponentMove(int position) {
        return getOpponent(position).getNextActionType();
    }

    public void makeOpponentDie(int position) {
        entitiesList.remove(position);
    }

    public boolean isFightOver() {
        int opponentDead = 0;
        for (int i = 1; i <= opponentAmount(); i++) {
            if (getOpponent(i).isDead()) {
                opponentDead++;
            }
        }

        if (opponentDead == opponentAmount()) {
            return true;
        } else return getPlayer().isDead();
    }

    public boolean playRoom() throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        while (!(isFightOver())) {
            display.displayFight(this);
            playPlayerTurn();
            if(isFightOver()){
                break;
            }
            playOpponentTurn();
        }
        return !getPlayer().isDead();
    }
}
