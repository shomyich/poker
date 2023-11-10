package WordGuessGame;


class GuessCounterDecorator implements Guesser {
    private final Guesser guesser;
    private int guessCount;

    public GuessCounterDecorator(Guesser guesser) {
        this.guesser = guesser;
        this.guessCount = 0;
    }

    @Override
    public void guess() {
        guesser.guess();
        guessCount++;
    }

    @Override
    public String getCurrentGuess() {
        return guesser.getCurrentGuess();
    }

    public int getGuessCount() {
        return guessCount;
    }
}
