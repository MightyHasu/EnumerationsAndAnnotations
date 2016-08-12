package cardSuit;

import interfaces.Card;

public class CardIml implements Card{

    private CardRank rank;
    private CardSuit suit;
    int power;

    public CardIml(String rank, String suit) {
        this.setRank(rank);
        this.setSuit(suit);
        this.setPower();
    }

    private void setPower() {
        this.power = rank.getCardPower() + suit.getSuitPower();
    }

    public int getPower() {
        return this.power;
    }

    public CardRank getRank() {
        return this.rank;
    }

    private void setRank(String rank) {
        this.rank = CardRank.valueOf(rank);
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    private void setSuit(String suit) {
        this.suit = CardSuit.valueOf(suit);
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %s", this.rank, this.suit, this.power);
    }

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getPower() > o2.getPower()) {
            return 1;
        } else if (o1.getPower() < o2.getPower()) {
            return -1;
        }

        return 0;
    }


    @Override
    public int compareTo(Card card) {
        return this.getPower() - card.getPower();
    }
}
