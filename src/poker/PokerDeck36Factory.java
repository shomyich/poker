package poker;

import poker.CardDeckFactory;

public class PokerDeck36Factory implements CardDeckFactory {
    @Override
    public PokerDeck createCardDeck() {
        return PokerDeck.getInstance(36);
    }
}