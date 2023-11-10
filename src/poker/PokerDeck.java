package poker;
import poker.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerDeck {

    private static PokerDeck instance;

    private final List<Card> cards;

    private PokerDeck(int deckSize) {
        cards = new ArrayList<>();
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 2; rank <= (deckSize == 36 ? 10 : 14); rank++) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Метод для получения единственного экземпляра PokerDeck
    public static PokerDeck getInstance(int deckSize) {
        if (instance == null) {
            instance = new PokerDeck(deckSize);
        }
        return instance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
