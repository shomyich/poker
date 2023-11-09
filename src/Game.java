import java.util.List;
import java.util.Scanner;

public class Game {

    public static void game() {
        System.out.println("****************************************************");
        CardDeckFactory cardDeckFactory;
        int deckSize = determineDeckSize();

        if (deckSize == 36) {
            cardDeckFactory = new PokerDeck36Factory();
        } else {
            cardDeckFactory = new PokerDeck52Factory();
        }

        PokerDeck deck = cardDeckFactory.createCardDeck();

        List<Card> cards = deck.getCards();
        deck.shuffle();

        Player Sasha = new Player("Sasha");
        Player Kostya = new Player("Kostya");

        Table.addObserver(Sasha);
        Table.addObserver(Kostya);


            for (int i = 0; i < 2; i++) {
                Sasha.addCard(cards.remove(cards.size() - 1));
                Kostya.addCard(cards.remove(cards.size() - 1));
            }

            Table table = new Table();
            for (int i = 0; i < 5; i++) {
                table.addCard(cards.remove(cards.size() - 1));
            }



            System.out.println(table.getCards());

                int winner = WinnerDeterminer.determineWinner(Sasha, Kostya, table);

                if (winner == 0) {
                    System.out.println("****************************************************");
                    Sasha.addBetMoney(Sasha.getBet() + Kostya.getBet());
                    Kostya.removeBetMoney(Kostya.getBet());
                } else if (winner == 1) {
                    System.out.println("****************************************************");
                    Kostya.addBetMoney(Sasha.getBet() + Kostya.getBet());
                    Sasha.removeBetMoney(Sasha.getBet());
                } else {
                    System.out.println("****************************************************");
                }
//            }
       }
    private static int determineDeckSize() {
        System.out.println("You can choose 36 or 52 cards in your deck?");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x==36){
            return 36;
        }
        return 52;
    }

}