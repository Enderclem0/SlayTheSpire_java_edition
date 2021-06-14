package main.Fight;

import main.Card.Card;
import main.Card.CardBuilder;
import main.Display;
import main.Room.Room;
import main.TextDisplay;
import main.UI;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FightRoom implements Room {
    private final ArrayList<FightEntity> entitiesList;
    private int nbTurns = 0;

    public FightRoom(PlayerAvatar playerAvatar,ArrayList<FightEntity> ennemies) {
        Objects.requireNonNull(ennemies);
        ArrayList<FightEntity> entities = new ArrayList<>();
        entities.add(playerAvatar);
        entities.addAll(ennemies);
        this.entitiesList = entities;
    }

    private Object getTarget(Card.targetType target) {
        boolean valid = false;
        Display display = TextDisplay.getDisplay();
        int chosen;
        switch (target) {
            case ENNEMY -> {
                do {
                    chosen = UI.getUserInput("Chose an opponent number");
                    if (chosen > 0 && chosen <= opponentAmount()) {
                        valid = true;
                    }
                } while (!valid);
                return getOpponent(chosen);
            }
            case CARD_DISCARD -> {
                do {
                    display.displayDiscard(getPlayer());
                    chosen = UI.getUserInput("Chose a card number from the discard");
                    if (chosen > 0 && chosen <= getPlayer().getDiscard().getSize()) {
                        valid = true;
                    }
                } while (!valid);
                return getPlayer().getDiscard().draw(chosen - 1);
            }
            case CARD_HAND -> {
                do {
                    chosen = UI.getUserInput("Chose a card in hand");
                    if (chosen > 0 && chosen <= getPlayer().getHand().getSize()) {
                        valid = true;
                    }
                } while (!valid);
                return getPlayer().getHand().getCard(chosen - 1);
            }
            case CARD_DRAWPILE -> {
                do {
                    display.displayDraw(getPlayer());
                    chosen = UI.getUserInput("Chose a card in drawpile");
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
            if (target != null) {
                chosenTarget.add(getTarget(target));
            }
        }
        card.playCard(this, chosenTarget);
    }

    public void playPlayerTurn() {
        Display display = TextDisplay.getDisplay();
        PlayerAvatar playerAvatar = getPlayer();
        playerAvatar.resetEnergy();
        playerAvatar.draw(5);
        boolean skip = false;
        while (!skip) {
            display.displayHand(playerAvatar.getHand());
            int chosen = UI.getUserInput("Chose a card number or -1 to skip ");
            if (chosen > 0 && chosen <= playerAvatar.getHand().getSize()) {
                Card card = playerAvatar.getCard(chosen - 1);
                if (playerAvatar.isCardPlayable(card)) {
                    playCard(card);
                    playerAvatar.getHand().removeCard(card);
                    display.displayFight(this);
                } else {
                    display.displayText("Card not playable");
                }
            } else {
                skip = true;
            }
        }
    }


    public void playOpponentTurn() throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        ArrayList<Opponent> ennemies = getAllOpponents();
        for (Opponent enemy : ennemies) {
            display.displayAction(enemy, this);
            TimeUnit.SECONDS.sleep(1);
            enemy.playNextAction(this);
        }
        nbTurns++;
    }

    public PlayerAvatar getPlayer() {
        return (PlayerAvatar) entitiesList.get(0);
    }

    public int opponentAmount() {
        return entitiesList.size() - 1;
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
            throw new IllegalArgumentException("Position must be above 0 and below the number of entities here:" + position);
        }
        return (Opponent) entitiesList.get(position);
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

    public boolean playRoom(Player player) throws InterruptedException {
        Display display = TextDisplay.getDisplay();
        while (!(isFightOver())) {
            display.displayFight(this);
            playPlayerTurn();
            if (isFightOver()) {
                break;
            }
            playOpponentTurn();
            endOfTurn();
        }
        rewardPlayer();
        return !getPlayer().isDead();
    }

    private void rewardPlayer() {
        CardBuilder cardBuilder = CardBuilder.getCardBuilder();
        Display display = TextDisplay.getDisplay();
        ArrayList<Card> reward = new ArrayList<>();
        reward.add(cardBuilder.createCard(CardBuilder.Color.IRONCLAD));
        reward.add(cardBuilder.createCard(CardBuilder.Color.IRONCLAD));
        reward.add(cardBuilder.createCard(CardBuilder.Color.IRONCLAD));
        display.displayText("Reward time !");
        for (Card card : reward) {
            display.displayCard(card);
        }
        boolean valid = false;
        while (!valid) {
            int chosen = UI.getUserInput("Chose a card number between 1 and 3");
            if (chosen <= 3 && chosen > 0) {
                getPlayer().addCard(reward.get(chosen));
                valid = true;
            }
        }

    }

    private void endOfTurn() {
        PlayerAvatar playerAvatar = getPlayer();
        playerAvatar.resetBlock();
        playerAvatar.debuffTurn();
        playerAvatar.discardHand();
        for (Opponent allOpponent : getAllOpponents()) {
            allOpponent.debuffTurn();
        }
        nbTurns++;
    }

    public int getTurn() {
        return nbTurns;
    }
}
