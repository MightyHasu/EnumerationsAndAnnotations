package cardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        //CardSuit[] cardSuit = CardSuit.values();
        //System.out.println("Card Suits:");
        //for (CardSuit suit : cardSuit) {
        //    System.out.printf("Ordinal value: %d; Name value: %s\n", suit.ordinal(), suit);
        //}

        //CardRank[] cardRank = CardRank.values();
        //System.out.println("Card Ranks:");
        //for (CardRank rank : cardRank) {
        //    System.out.printf("Ordinal value: %d; Name value: %s\n", rank.ordinal(), rank);
        //}

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cardRank = reader.readLine();
        String cardSuit = reader.readLine();

        CardRank card = CardRank.valueOf(cardRank);
        CardSuit suit = CardSuit.valueOf(cardSuit);

        System.out.printf("Card name: %s of %s; Card power: %d\n",
                CardRank.valueOf(CardRank.class, cardRank),
                CardSuit.valueOf(CardSuit.class, cardSuit),
                (CardRank.valueOf(CardRank.class, cardRank).getCardPower())
                        +(CardSuit.valueOf(CardSuit.class, cardSuit).getSuitPower()));

        System.out.printf("Card name: %s of %s; Card power: %d\n",
                card,
                suit,
                card.getCardPower()+suit.getSuitPower());
    }

}
