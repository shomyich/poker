import java.util.List;

public enum HandType implements Comparable<HandType> {

    ROYAL_FLUSH(1),
    STRAIGHT_FLUSH(2),
    FOUR_OF_A_KIND(3),
    FULL_HOUSE(4),
    FLUSH(5),
    STRAIGHT(6),
    THREE_OF_A_KIND(7),
    TWO_PAIRS(8),
    PAIR(9),
    HIGH_CARD(10);

    private final int rank;

    HandType(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public boolean isApplicable(List<Card> cards) {
        switch (this) {
            case ROYAL_FLUSH:
                return isRoyalFlush(cards);
            case STRAIGHT_FLUSH:
                return isStraightFlush(cards);
            case FOUR_OF_A_KIND:
                return isFourOfAKind(cards);
            case FULL_HOUSE:
                return isFullHouse(cards);
            case FLUSH:
                return isFlush(cards);
            case STRAIGHT:
                return isStraight(cards);
            case THREE_OF_A_KIND:
                return isThreeOfAKind(cards);
            case TWO_PAIRS:
                return isTwoPairs(cards);
            case PAIR:
                return isPair(cards);
            case HIGH_CARD:
                return true;
            default:
                return false;
        }
    }



    public static int compareByOrdinal(HandType type1, HandType type2) {
        return Integer.compare(type1.ordinal(), type2.ordinal());
    }

    private static boolean isRoyalFlush(List<Card> cards) {
        return isFlush(cards) && isStraight(cards) && cards.get(4).getRank() == 14; // Ace
    }

    private static boolean isStraightFlush(List<Card> cards) {
        return isFlush(cards) && isStraight(cards);
    }

    private static boolean isFourOfAKind(List<Card> cards) {
        return countCards(cards, 4) > 0;
    }

    private static boolean isFullHouse(List<Card> cards) {
        return (countCards(cards, 3) > 0) && (countCards(cards, 2) > 0);
    }

    private static boolean isFlush(List<Card> cards) {
        return cards.stream().map(Card::getSuit).distinct().count() == 1;
    }

    private static boolean isStraight(List<Card> cards) {
        for (int i = 0; i < cards.size() - 4; i++) {
            if (cards.get(i).getRank() + 4 == cards.get(i + 1).getRank()) {
                return true;
            }
        }

        return false;
    }

    private static boolean isThreeOfAKind(List<Card> cards) {
        return countCards(cards, 3) == 1;
    }

    private static boolean isTwoPairs(List<Card> cards) {
        return (countCards(cards, 2) == 2) && (countCards(cards, 1) == 0);
    }

    private static boolean isPair(List<Card> cards) {
        return countCards(cards, 2) > 0;
    }

    private static int countCards(List<Card> cards, int rank) {
        int count = 0;
        for (Card card : cards) {
            if (card.getRank() == rank) {
                count++;
            }
        }

        return count;
    }
}
