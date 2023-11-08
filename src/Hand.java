    import java.util.Collections;
    import java.util.List;

    public class Hand {

        private List<Card> cards;

        public Hand(HandType handType, List<Card> cards) {
            this.cards = cards;
        }

        public static Hand getBestHand(List<Card> hand, List<Card> board) {
            Hand bestHand = null;
            for (Card card : board) {
                hand.add(card);
            }
            Collections.sort(hand);

            for (HandType handType : HandType.values()) {
                if (handType.isApplicable(hand)) {
                    if (bestHand == null || handType.compareTo(bestHand.getType()) > 0) {
                        bestHand = new Hand(handType, hand);
                    }
                }
            }

            return bestHand;
        }

        public HandType getType() {
            return getHandType(cards);
        }

        public int compareTo(Hand hand) {
            return getType().compareTo(hand.getType());
        }

        private static HandType getHandType(List<Card> cards) {
            HandType type;

            // Check for Royal Flush
            if (isRoyalFlush(cards)) {
                type = HandType.ROYAL_FLUSH;
            } else if (isStraightFlush(cards)) {
                type = HandType.STRAIGHT_FLUSH;
            } else if (isFourOfAKind(cards)) {
                type = HandType.FOUR_OF_A_KIND;
            } else if (isFullHouse(cards)) {
                type = HandType.FULL_HOUSE;
            } else if (isFlush(cards)) {
                type = HandType.FLUSH;
            } else if (isStraight(cards)) {
                type = HandType.STRAIGHT;
            } else if (isThreeOfAKind(cards)) {
                type = HandType.THREE_OF_A_KIND;
            } else if (isTwoPairs(cards)) {
                type = HandType.TWO_PAIRS;
            } else if (isPair(cards)) {
                type = HandType.PAIR;
            } else {
                type = HandType.HIGH_CARD;
            }

            return type;
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