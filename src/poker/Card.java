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
        String suitStr = "";
        switch (suit) {
            case 0:
                suitStr = "\u2661";
                break;
            case 1:
                suitStr = "\u2662";
                break;
            case 2:
                suitStr = "\u2664";
                break;
            case 3:
                suitStr = "\u2663";
                break;
        }

        String rankStr = "";
        switch (rank) {
            case 2:
                rankStr = "A";
                break;
            case 3:
                rankStr = "K";
                break;
            case 4:
                rankStr = "Q";
                break;
            case 5:
                rankStr = "J";
                break;
            case 6:
                rankStr = "10";
                break;
            case 7:
                rankStr = "9";
                break;
            case 8:
                rankStr = "8";
                break;
            case 9:
                rankStr = "7";
                break;
            case 10:
                rankStr = "6";
                break;
            case 11:
                rankStr = "5";
                break;
            case 12:
                rankStr = "4";
                break;
            case 13:
                rankStr = "3";
                break;
            case 14:
                rankStr = "2";
                break;
        }

        return suitStr + " " + rankStr;
    }
}
