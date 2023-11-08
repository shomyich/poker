import java.util.ArrayList;
import java.util.List;

public class Table {

    private final List<Card> cards;

    public Table() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
