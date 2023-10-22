package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
    private Card hand;

    private int score;

    private boolean protectedC;

    private boolean isOut;


    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.protectedC = false;
        this.isOut = false;
    }



    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
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
    public boolean isProtectedC() {
        return protectedC;
    }

    public void setProtectedC(boolean protectedC) {
        this.protectedC = protectedC;
    }




    public Card playCard(Card card, Scanner scanner, List <Player> players) {
        card.effect(this, players, scanner);
        return card;
    }
    // printing the player's hand to the console
    public void showHand() {
        System.out.println("Current hand for " + name + ":");
    }

    public boolean hasCard(int hierarchy) {
        return hand.getHierarchy() == hierarchy;
    }

    public void addToScore(int roundScore) {
        this.score += roundScore;
    }

}
