import java.util.ArrayList;
import java.util.List;

public class WinnerDeterminer {

    public static int determineWinner(Player player1, Player player2, Table table) {
        List<Card> hand1 = player1.getHand();
        List<Card> hand2 = player2.getHand();
        List<Card> board = table.getCards();

        // **Создание списка всех карт, доступных игрокам**

        List<Card> allCards1 = new ArrayList<>();
        List<Card> allCards2 = new ArrayList<>();
        allCards1.addAll(hand1);
        allCards2.addAll(hand2);
        allCards1.addAll(board);
        allCards2.addAll(board);

        // **Определение комбинаций игроков**

        Hand player1Hand = Hand.getBestHand(hand1, board);
        Hand player2Hand = Hand.getBestHand(hand2, board);

        // **Определение победителя**

        if (player1Hand.compareTo(player2Hand) > 0) {
            return 0; // Победил игрок 1
        } else if (player1Hand.compareTo(player2Hand) < 0) {
            return 1; // Победил игрок 2
        } else {
            return 2; // Ничья
        }
    }
}
