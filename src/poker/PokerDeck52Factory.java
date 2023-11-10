package poker;
import poker.CardDeckFactory;

public class PokerDeck52Factory implements CardDeckFactory {
    @Override
    public PokerDeck createCardDeck() {
        return PokerDeck.getInstance(52);
    }
}