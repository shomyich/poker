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
    public static Hand getBestHand(List<Card> allCards) {
        List<List<Card>> combinations = Combinatorics.generateCombinations(allCards, 7);

        Hand bestHand = new Hand(combinations.get(0));

        for (List<Card> combination : combinations) {
            Hand currentHand = new Hand(combination);
            if (currentHand.compareTo(bestHand) > 0) {
                bestHand = currentHand;
            }
        }
        // System.out.println(bestHand.cards);
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
        for (int i = 4; i >= 0; i--) {
            int rankComparison = this.cards.get(i).getRank() - other.cards.get(i).getRank();
            if (rankComparison != 0) {
                return rankComparison;
            }
        }
        return 0;
    }
}
