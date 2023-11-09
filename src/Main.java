import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Hello! Let's play!");

        int x = 0;
        Scanner sc = new Scanner(System.in);
        while (x!=3){
            System.out.println("Please choose game: \n" +
                    "1 - Poker\n" +
                    "2 - NANANA\n" +
                    "3 - exit from Game");
            System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
            x = sc.nextInt();
            switch (x){

                case 1:
                    Game game = new Game();
                    game.game();
                case 2:
                    System.out.println("NANANNANAN");
                case 3:
                    break;
            }
        }




    }
}