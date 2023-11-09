package WordGuessGame;

import java.util.Random;

class ComputerGuesser implements Guesser {
    private String targetWord;
    private String currentGuess;

    public ComputerGuesser(String targetWord) {
        this.targetWord = targetWord;
        this.currentGuess = "_".repeat(targetWord.length());
    }

    @Override
    public void guess() {
        Random random = new Random();
        boolean found = false;
        while (!found) {
            int index = random.nextInt(targetWord.length());
            if (currentGuess.charAt(index) == '_') {
                char letter = targetWord.charAt(index);
                updateCurrentGuess(index, letter);
                found = true;
            } else {
                displayIncorrectGuess(index, targetWord.charAt(index));
            }
        }
    }

    private void updateCurrentGuess(int index, char letter) {
        StringBuilder builder = new StringBuilder(currentGuess);
        builder.setCharAt(index, letter);
        currentGuess = builder.toString();
        displayCorrectGuess(currentGuess);
    }

    private void displayCorrectGuess(String currentGuess) {
        System.out.println("Computer's Guess: " + currentGuess);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayIncorrectGuess(int index, char letter) {
        String displayString = currentGuess.substring(0, index) + letter + currentGuess.substring(index + 1);
        System.out.println("Computer's Guess: " + displayString + " - Incorrect Guess, letter: " + letter + ", index: " + index);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCurrentGuess() {
        return currentGuess;
    }
}
