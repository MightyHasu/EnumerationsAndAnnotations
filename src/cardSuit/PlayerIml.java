package cardSuit;

import interfaces.Card;
import interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerIml implements Player{
    private String name;
    private List<Card> cards;
    private int points;

    public PlayerIml(String name) {
        this.setName(name);
        this.cards = new ArrayList<>();
        this.points = 0;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public boolean addCard(Card card) {
        if (!cards.contains(card)&&fullHand()){
            cards.add(card);
            int points = card.getPower();
            calculatePoints(points);
            return true;
        }

        return false;
    }

    @Override
    public Card getHighestCard() {
        Card highestCard = this.cards.get(0);

        for (int i = 1; i < this.cards.size(); i++) {
            if (highestCard.compareTo(this.cards.get(i))<0){
                highestCard = this.cards.get(i);
            }
        }
        return highestCard;
    }

    private void calculatePoints(int points) {
        this.points = this.points + points;
    }

    private boolean fullHand(){
        if (this.cards.size()>=5) {
            return false;
        }
        else {
            return true;
        }
    }
}
