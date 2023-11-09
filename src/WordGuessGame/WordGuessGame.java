package WordGuessGame;

public class WordGuessGame {
    public static void main(String args) {
        String targetWord = args;

        ComputerGuesser computer = new ComputerGuesser(targetWord);

        GuesserAdapter adapter = new GuesserAdapter(computer);
        GuessCounterDecorator decorator = new GuessCounterDecorator(adapter);

        while (!decorator.getCurrentGuess().equals(targetWord)) {
            decorator.guess();
        }

        System.out.println("Computer has guessed the word!");
        System.out.println("Total guesses made: " + decorator.getGuessCount());
    }
}
