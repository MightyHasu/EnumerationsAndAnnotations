package cardSuit;

import anotations.CardAnotation;

@CardAnotation(type = "Type = Enumeration",
        description = "Description = Provides suit constants for a Card class.",
        category = "Category = Suit")
public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    private CardSuit(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
