package WordGuessGame;

public class WordGuessGame {
    public static void main(String args) {

        ComputerGuesser computer = new ComputerGuesser(args);

        GuesserAdapter adapter = new GuesserAdapter(computer);
        GuessCounterDecorator decorator = new GuessCounterDecorator(adapter);

        while (!decorator.getCurrentGuess().equals(args)) {
            decorator.guess();
        }

        System.out.println("Computer has guessed the word!");
        System.out.println("Total guesses made: " + decorator.getGuessCount());
    }
}
