import java.util.List;

public class WinnerDeterminer {

    public static int determineWinner(Player player1, Player player2, Table table) {
        List<Card> hand1 = player1.getHand();
        List<Card> hand2 = player2.getHand();
        List<Card> board = table.getCards();

        Hand player1Hand = Hand.getBestHand(hand1, board);
        System.out.println(player1Hand.getHandType());


        Hand player2Hand = Hand.getBestHand(hand2, board);
        System.out.println(player2Hand.getHandType());

        if (player1Hand.compareTo(player2Hand) > 0) {
            return 0; // Player 1 wins
        } else if (player1Hand.compareTo(player2Hand) < 0) {
            return 1; // Player 2 wins
        } else {
            return 2; // It's a tie
        }
    }
}
