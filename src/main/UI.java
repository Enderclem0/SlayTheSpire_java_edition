package main;

import main.Card.Card;
import main.Card.CardBuilder;
import main.Fight.FightEntity;
import main.Fight.FightRoom;
import main.Fight.Opponent;
import main.Fight.PlayerAvatar;
import main.Room.RoomBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private UI() {
    }

    public static void main(String[] args) throws InterruptedException {
        Mapbuilder mapbuilder = Mapbuilder.getMapBuilder();
        CardBuilder cardBuilder = CardBuilder.getCardBuilder();
        boolean debug = getUserInput("Type 1 to enter debug mode") == 1;
        PlayerAvatar playerAvatar = new PlayerAvatar(80, 3, 80, 3);
        if (debug) {
            int chosen;
            int numOfCard;
            String card;
            do {
                chosen = getUserInput("1 : Add card, 2 : list Card, 3 : setup Fight");
                switch (chosen) {
                    case 1 -> {
                        card = getTextInput("Chose card");
                        numOfCard = getUserInput("Chose number of card to add");
                        Card cardAdd = cardBuilder.getCard(card);
                        if (!(cardAdd == null)) {
                            playerAvatar.addCard(cardAdd, numOfCard);
                        }
                    }
                    case 3 -> {
                    }
                    case 2 -> {
                        for (Card cardAll : cardBuilder.getAllCards()) {
                            System.out.println(cardAll.name() + " " + cardAll.description());
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + chosen);
                }
            } while (!(chosen == 3));
            String ennemy;
            ArrayList<FightEntity> ennemies = new ArrayList<>();
            do {
                chosen = getUserInput("1 : Add monster, 2 : list Monster, 3 : Start");
                switch (chosen) {
                    case 1 -> {
                        ennemy = getTextInput("Chose opponent");
                        Opponent opponentAdd = RoomBuilder.getRoomBuilder().getOpponent(ennemy);
                        if (!(opponentAdd == null)) {
                            ennemies.add(opponentAdd);
                        }
                    }
                    case 2 -> {
                        for (Opponent allOpponent : RoomBuilder.getRoomBuilder().getAllOpponents()) {
                            System.out.println(allOpponent.getName());
                        }
                    }
                    case 3 -> {
                        FightRoom fightRoom = new FightRoom(playerAvatar, ennemies);
                        fightRoom.playRoom(playerAvatar);
                    }
                }
            } while (!(chosen == 3));
        } else {
            GameMap map = mapbuilder.createMap(playerAvatar);
            playerAvatar.addCard(cardBuilder.getCard("Strike"), 5);
            playerAvatar.addCard(cardBuilder.getCard("Defend"), 4);
            playerAvatar.addCard(cardBuilder.getCard("Bash"));
            map.playMap(playerAvatar);
        }
    }

    public static int getUserInput(String textToDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToDisplay);
        return scanner.nextInt();
    }

    public static String getTextInput(String textToDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToDisplay);
        return scanner.next();
    }
}
