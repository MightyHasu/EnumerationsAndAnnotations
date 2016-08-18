package cardSuit;

import anotations.CardAnotation;
import interfaces.Card;
import interfaces.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        cardGame();

        //printDeck();

        //implementCards();

        //printnnotations();

    }

    public static void printDeck() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                System.out.println(cardRank.name() + " of " + cardSuit.name());
            }
        }
    }

    public static void implementCards() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cardRank = reader.readLine();
        String cardSuit = reader.readLine();

        Card firstCard = new CardIml(cardRank, cardSuit);
        cardRank = reader.readLine();
        cardSuit = reader.readLine();
        Card secondCard = new CardIml(cardRank, cardSuit);

        if (firstCard.compareTo(secondCard) > 0) {
            System.out.println(firstCard.toString());
        }
        System.out.println(secondCard.toString());

    }

    public static void printnnotations() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<CardRank> cardRankClass = CardRank.class;

        Class<CardSuit> cardSuitClass = CardSuit.class;

        String in = reader.readLine();

        switch (in) {
            case "Rank":
                CardAnotation cardAnotation = cardRankClass.getAnnotation(CardAnotation.class);
                System.out.println(cardAnotation.type() + ", " + cardAnotation.description());
                break;
            case "Suit":
                cardAnotation = cardSuitClass.getAnnotation(CardAnotation.class);
                System.out.println(cardAnotation.type() + ", " + cardAnotation.description());
                break;
            default:
                break;
        }
    }

    public static void cardGame() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String playerName = "";

        List<Card> pulledCards = new ArrayList<>();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < 2; i++) {

            playerName = reader.readLine();

            Player player = new PlayerIml(playerName);

            if (player != null) {
                players.add(player);
            }
        }

        int counter = 0;

        while (counter != 10) {
            String[] cardTokens = reader.readLine().split("\\s+");
            if (!checkCard(cardTokens)) {
                System.out.println("No such card exists.");
                continue;
            }

            String rank = cardTokens[0];

            String suit = cardTokens[2];

            Card card = new CardIml(rank, suit);

            if (pulledCards.contains(card)) {
                System.out.println("Card is not in the deck.");
                continue;
            }

            pulledCards.add(card);

            counter++;

            if (counter <= 5) {
                players.get(0).addCard(card);
            } else {
                players.get(1).addCard(card);
            }

        }

        if (players.get(0).getHighestCard()
                .compareTo(players.get(1).getHighestCard()) > 0) {

            System.out.printf("%s wins with %s of %s.",
                    players.get(0).getName(),
                    players.get(0).getHighestCard().getRank(),
                    players.get(0).getHighestCard().getSuit());
        } else {
            System.out.printf("%s wins with %s of %s.",
                    players.get(1).getName(),
                    players.get(1).getHighestCard().getRank(),
                    players.get(1).getHighestCard().getSuit());

        }
    }

    public static boolean checkCard(String[] cardTokens) {

        if (cardTokens.length != 3) {
            return false;
        }

        String rank = cardTokens[0];

        String suit = cardTokens[2];

        int rankcounter = 0;
        for (CardRank cardRank : CardRank.values()) {
            if (!cardRank.name().equals(rank)) {
                rankcounter++;
            }
        }

        int suitcounter = 0;

        for (CardSuit cardSuit : CardSuit.values()) {
            if (!cardSuit.name().equals(suit)) {
                suitcounter++;
            }
        }

        if (suitcounter==4||rankcounter==13){
            return false;
        }

        return true;


    }

}
