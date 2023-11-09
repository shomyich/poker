import java.util.List;
import java.util.Scanner;

public class Game {

    public static void game() {
        CardDeckFactory cardDeckFactory;
        int deckSize = determineDeckSize(); // Метод, определяющий размер колоды

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
            System.out.println(Sasha.getHand());
        System.out.println(Kostya.getHand());
        System.out.println(table.getCards());
            // **Добавление проверки ставок**


//            while (cards.size() > 0) {
//                System.out.println("Саша, время сделать ставку!");
//                System.out.println("У тебя на счету: " + Sasha.getBetMoney());
//                System.out.println("Введи, сколько хочешь поставить:");
//                Scanner scanner = new Scanner(System.in);
//                int bet = scanner.nextInt();
//                if (bet <= Sasha.getBetMoney() && bet <= Kostya.getBetMoney()) {
//                    Sasha.setBet(bet);
//                    break;
//                } else {
//                    System.out.println("У тебя недостаточно денег для этой ставки.");
//                }
//            }
//
//            while (cards.size() > 0) {
//                System.out.println("Костя, время сделать ставку!");
//                System.out.println("У тебя на счету: " + Kostya.getBetMoney());
//                System.out.println("Введи, сколько хочешь поставить:");
//                Scanner scanner = new Scanner(System.in);
//                int bet = scanner.nextInt();
//                if (bet <= Kostya.getBetMoney() && bet <= Sasha.getBet()) {
//                    Kostya.setBet(bet);
//                    break;
//                } else {
//                    System.out.println("У тебя недостаточно денег для этой ставки.");
//                }
//            }
//            while (cards.size() > 0) {
//                for (int i = 0; i < 2; i++) {
//
//                    Sasha.addCard(cards.remove(cards.size() - 1));
//                    Kostya.addCard(cards.remove(cards.size() - 1));
//                }
//
//                // **Добавление возможности сбросить ставки**
//
//                if (Sasha.getBet() > Sasha.getBetMoney()) {
//                    System.out.println("У Саши недостаточно денег для этой ставки.");
//                    System.out.println("Саша, хочешь сбросить ставку? (y/n)");
//                    Scanner scanner = new Scanner(System.in);
//                    String choice = scanner.next();
//                    if (choice.equals("y")) {
//                        Sasha.setBet(0);
//                    }
//                }
//
//                if (Kostya.getBet() > Kostya.getBetMoney()) {
//                    System.out.println("У Кости недостаточно денег для этой ставки.");
//                    System.out.println("Костя, хочешь сбросить ставку? (y/n)");
//                    Scanner scanner = new Scanner(System.in);
//                    String choice = scanner.next();
//                    if (choice.equals("y")) {
//                        Kostya.setBet(0);
//                    }
//                }
//                // **Окончание игры в случае равенства ставок**
//
//
//                // **Добавление хода флопа**
//                System.out.println(Sasha.getHand());
//                System.out.println(Kostya.getHand());
//                System.out.println("Флоп:");
//                for (int i = 0; i < 3; i++) {
//                    table.addCard(cards.remove(cards.size() - 1));
//                    System.out.println(table.getCards().get(i));
//                }
//
//                // **Добавление хода терна**
//
//                System.out.println("Терн:");
//                table.addCard(cards.remove(cards.size() - 1));
//                System.out.println(table.getCards().get(3));
//
//                // **Добавление хода ривера**
//
//                System.out.println("Ривер:");
//                table.addCard(cards.remove(cards.size() - 1));
//                System.out.println(table.getCards().get(4));
//
//                // **Определение победителя**
//
                int winner = WinnerDeterminer.determineWinner(Sasha, Kostya, table);

                // **Вывод результатов**

                if (winner == 0) {
                    System.out.println("Победил Саша!");
                    Sasha.addBetMoney(Sasha.getBet() + Kostya.getBet());
                    Kostya.removeBetMoney(Kostya.getBet());
                } else if (winner == 1) {
                    System.out.println("Победил Костя!");
                    Kostya.addBetMoney(Sasha.getBet() + Kostya.getBet());
                    Sasha.removeBetMoney(Sasha.getBet());
                } else {
                    System.out.println("Ничья!");
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