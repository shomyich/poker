package poker;

public class Card implements Comparable<Card> {

    private final int suit;
    private final int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card card) {
        if (suit != card.suit) {
            return suit - card.suit;
        } else {
            return rank - card.rank;
        }
    }

    @Override
    public String toString() {
        String suitStr = switch (suit) {
            case 0 -> "♡";
            case 1 -> "♢";
            case 2 -> "♤";
            case 3 -> "♣";
            default -> "";
        };

        String rankStr = switch (rank) {
            case 2 -> "A";
            case 3 -> "K";
            case 4 -> "Q";
            case 5 -> "J";
            case 6 -> "10";
            case 7 -> "9";
            case 8 -> "8";
            case 9 -> "7";
            case 10 -> "6";
            case 11 -> "5";
            case 12 -> "4";
            case 13 -> "3";
            case 14 -> "2";
            default -> "";
        };

        return suitStr + " " + rankStr;
    }
}
