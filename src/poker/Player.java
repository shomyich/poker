package poker;

import java.util.ArrayList;
import java.util.List;

public class Player implements Observer {
    // Existing code


    private final String name;
    private final List<Card> hand;
    private int betMoney;
    private int bet;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.betMoney = 10000;
    }
    public void addBetMoney(int winBet){
        betMoney = getBetMoney()+ winBet;
    }
    public void removeBetMoney(int looseBet){
        betMoney = getBetMoney()- looseBet;
    }
    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public int getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    @Override
    public void update() {
        System.out.println("New cards on the Table! ");

    }
    public String toString() {
        return name + " (" + hand.size() + " cards, Money: " + betMoney + ")";
    }
}
