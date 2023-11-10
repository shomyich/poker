import poker.Game;
import WordGuessGame.WordGuessGame;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Hello! Let's play!");

        int x = 0;
        Scanner sc = new Scanner(System.in);
        while (x != 3) {
            System.out.println("""
                    Please choose game:\s
                    1 - Poker
                    2 - Word Guesser
                    3 - exit from Game""");
            System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
            x = sc.nextInt();
            switch (x) {

                case 1:

                    Game.game();
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Input word");
                    String str = scanner.nextLine();
                    WordGuessGame.main(str);
                    break;
                case 3:
                    break;
            }
        }


    }
}