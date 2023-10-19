package game;


public class Player {

    private String name;
    private Card hand;
    private int score;




    public Player(String name) {
        this.name = name;
        this.score = 0;

    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Card getHand() {
        return hand; // returns a players hand as an ArrayList of Cards
    }

    public  void setHand(Card card) {
        this.hand = card;
    }

    public void playCard( ) {
       hand.effect();
    }

    // printing the player's hand to the console
    public void showHand() {
        System.out.println("Current hand for " + name + ":");
    }


}
