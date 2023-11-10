package poker;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final List<Card> cards;
    private static final List<Observer> observers = new ArrayList<>();  // Initialize here

    public Table() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);

    }

    public List<Card> getCards() {
        return cards;
    }

    public static void addObserver(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    private static void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
