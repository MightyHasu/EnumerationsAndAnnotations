package interfaces;

import cardSuit.CardRank;
import cardSuit.CardSuit;

import java.util.Comparator;

public interface Card extends Comparable<Card>, Comparator<Card> {
    int getPower();
    CardRank getRank();
    CardSuit getSuit();
}
