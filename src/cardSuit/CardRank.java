package cardSuit;


import anotations.CardAnotation;

import java.lang.annotation.Annotation;

@CardAnotation(type = "Enumeration",
        description = "Provides rank constants for a Card class.",
        getAnotaion = "Type = Enumeration, Description = Provides rank constants for a Card class.")
public enum CardRank {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int cardPower;

    private CardRank(int cardPower) {
        this.cardPower = cardPower;

    }



    public int getCardPower() {
        return cardPower;
    }


    private Annotation[] getAnnotations() {
        return
    }
}
