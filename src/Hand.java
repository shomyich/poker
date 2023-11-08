import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private static List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
    }

    public HandType getHandType() {
        if (isRoyalFlush()) {
            return HandType.ROYAL_FLUSH;
        }
        if (isStraightFlush()) {
            return HandType.STRAIGHT_FLUSH;
        }
        if (isFourOfAKind()) {
            return HandType.FOUR_OF_A_KIND;
        }
        if (isFullHouse()) {
            return HandType.FULL_HOUSE;
        }
        if (isFlush()) {
            return HandType.FLUSH;
        }
        if (isStraight()) {
            return HandType.STRAIGHT;
        }
        if (isThreeOfAKind()) {
            return HandType.THREE_OF_A_KIND;
        }
        if (isTwoPairs()) {
            return HandType.TWO_PAIRS;
        }
        if (isPair()) {
            return HandType.PAIR;
        }
        return HandType.HIGH_CARD;
    }

    public int compareTo(Hand other) {
        return this.getHandType().compareTo(other.getHandType());
    }

    public static Hand getBestHand(List<Card> board, List<Card> cards) {
        if (board.size() + cards.size() != 7) {
            throw new IllegalArgumentException("A hand must consist of exactly 7 cards.");
        }

        List<Card> allCards = new ArrayList<>(board);
        allCards.addAll(cards);
        Collections.sort(allCards);

        Hand bestHand = null;

        // Перебор всех возможных комбинаций из 5 карт
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    for (int l = k + 1; l < 6; l++) {
                        for (int m = l + 1; m < 7; m++) {
                            List<Card> currentCombination = new ArrayList<>();
                            currentCombination.add(allCards.get(i));
                            currentCombination.add(allCards.get(j));
                            currentCombination.add(allCards.get(k));
                            currentCombination.add(allCards.get(l));
                            currentCombination.add(allCards.get(m));

                            Hand currentHand = new Hand(currentCombination);
                            if (bestHand == null || currentHand.compareTo(bestHand) > 0) {
                                bestHand = currentHand;
                            }
                        }
                    }
                }
            }
        }

        return bestHand;
    }

    private static boolean isRoyalFlush() {
        return isStraightFlush() && cards.get(4).getRank() == 14; // Ace
    }

    private static boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private static boolean isFourOfAKind() {
        for (int i = 0; i < 2; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank() &&
                    cards.get(i).getRank() == cards.get(i + 2).getRank() &&
                    cards.get(i).getRank() == cards.get(i + 3).getRank()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFullHouse() {
        if (cards.get(0).getRank() == cards.get(1).getRank() &&
                cards.get(2).getRank() == cards.get(3).getRank() &&
                cards.get(3).getRank() == cards.get(4).getRank()) {
            return true;
        }
        if (cards.get(0).getRank() == cards.get(1).getRank() &&
                cards.get(1).getRank() == cards.get(2).getRank() &&
                cards.get(3).getRank() == cards.get(4).getRank()) {
            return true;
        }
        return false;
    }

    private static boolean isFlush() {
        return cards.get(0).getSuit() == cards.get(1).getSuit() &&
                cards.get(0).getSuit() == cards.get(2).getSuit() &&
                cards.get(0).getSuit() == cards.get(3).getSuit() &&
                cards.get(0).getSuit() == cards.get(4).getSuit();
    }

    private static boolean isStraight() {
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getRank() - 1 != cards.get(i + 1).getRank()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeOfAKind() {
        for (int i = 0; i < 3; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank() &&
                    cards.get(i).getRank() == cards.get(i + 2).getRank()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTwoPairs() {
        int pairCount = 0;
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
                pairCount++;
                i++; // Skip the next card in the pair
            }
        }
        return pairCount == 2;
    }

    private static boolean isPair() {
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
                return true;
            }
        }
        return false;
    }



    private static boolean isApplicable(List<Card> cards, HandType handType) {
        switch (handType) {
            case ROYAL_FLUSH:
                return isRoyalFlush();
            case STRAIGHT_FLUSH:
                return isStraightFlush();
            case FOUR_OF_A_KIND:
                return isFourOfAKind();
            case FULL_HOUSE:
                return isFullHouse();
            case FLUSH:
                return isFlush();
            case STRAIGHT:
                return isStraight();
            case THREE_OF_A_KIND:
                return isThreeOfAKind();
            case TWO_PAIRS:
                return isTwoPairs();
            case PAIR:
                return isPair();
            case HIGH_CARD:
                return true;
            default:
                throw new IllegalStateException("Unexpected value: " + handType);
        }
    }
}
