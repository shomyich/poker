package poker;

import java.util.ArrayList;
import java.util.List;

public class Combinatorics {

    public static List<List<Card>> generateCombinations(List<Card> cards, int choose) {
        List<List<Card>> combinations = new ArrayList<>();
        generateCombinations(cards, choose, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinations(List<Card> cards, int choose, int start, List<Card> current,
                                             List<List<Card>> combinations) {
        if (choose == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= cards.size() - choose; i++) {
            current.add(cards.get(i));
            generateCombinations(cards, choose - 1, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}
