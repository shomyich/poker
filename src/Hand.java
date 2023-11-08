import java.util.*;

public class Hand {

    private List<Card> cards;
    private List<Card> combination;

    public Hand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
        this.combination = new ArrayList<>(cards.subList(0, 5));
    }

    public void add(Card card) {
        combination.add(card);
        Collections.sort(combination);
    }
    public static Hand getBestHand(List<Card> hand1, List<Card> board) {
        List<Card> cards = new ArrayList<>(board);
        cards.addAll(hand1);
        Hand bestHand = new Hand(new ArrayList<>(cards.subList(0, 5))); // Начинаем с первых 5 карт

        for (int i = 0; i < cards.size() - 4; i++) {
            for (int j = i + 1; j < cards.size() - 3; j++) {
                for (int k = j + 1; k < cards.size() - 2; k++) {
                    for (int m = k + 1; m < cards.size() - 1; m++) {
                        for (int n = m + 1; n < cards.size(); n++) {
                            Hand currentHand = new Hand(new ArrayList<>(cards.subList(0, 5)));
                            currentHand.add(cards.get(i));
                            currentHand.add(cards.get(j));
                            currentHand.add(cards.get(k));
                            currentHand.add(cards.get(m));
                            currentHand.add(cards.get(n));

                            if (currentHand.compareTo(bestHand) > 0) {
                                bestHand = currentHand;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(bestHand.cards);
        return bestHand;
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

    private boolean isRoyalFlush() {
        return isStraightFlush() && cards.get(4).getRank() == 14; // Ace
    }

    private boolean isStraightFlush() {
        return isStraight() && isFlush();
    }

    private boolean isStraight() {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank() != cards.get(i + 1).getRank() - 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isFlush() {
        int suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    private boolean isFourOfAKind() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : cards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }

        for (int count : rankCounts.values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : cards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }

        int threeCount = 0;
        int twoCount = 0;
        for (int count : rankCounts.values()) {
            if (count == 3) {
                threeCount++;
            }
            if (count == 2) {
                twoCount++;
            }
        }

        return threeCount == 1 && twoCount == 1;
    }

    private boolean isThreeOfAKind() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : cards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }

        for (int count : rankCounts.values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPairs() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : cards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }

        int pairCount = 0;
        for (int count : rankCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }

        return pairCount == 2;
    }

    private boolean isPair() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : cards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }

        return rankCounts.values().stream().anyMatch(count -> count == 2);
    }

    public int compareTo(Hand other) {
        HandType thisHandType = this.getHandType();
        HandType otherHandType = other.getHandType();

        if (thisHandType != otherHandType) {
            return thisHandType.compareTo(otherHandType);
        }

        List<Card> thisCards = new ArrayList<>(this.combination);
        List<Card> otherCards = new ArrayList<>(other.combination);

        Collections.sort(thisCards);
        Collections.sort(otherCards);

        for (int i = 4; i >= 0; i--) {
            int rankComparison = thisCards.get(i).getRank() - otherCards.get(i).getRank();
            if (rankComparison != 0) {
                return rankComparison;
            }
        }

        return 0;
    }
}
