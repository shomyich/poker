package WordGuessGame;


class GuesserAdapter implements Guesser {
    private final ComputerGuesser computerGuesser;

    public GuesserAdapter(ComputerGuesser computerGuesser) {
        this.computerGuesser = computerGuesser;
    }

    @Override
    public void guess() {
        computerGuesser.guess();
    }

    @Override
    public String getCurrentGuess() {
        return computerGuesser.getCurrentGuess();
    }
}