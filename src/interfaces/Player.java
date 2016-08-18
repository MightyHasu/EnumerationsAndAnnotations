package interfaces;

public interface Player {
    String getName();
    int getPoints();
    boolean addCard(Card card);
    Card getHighestCard();
}
