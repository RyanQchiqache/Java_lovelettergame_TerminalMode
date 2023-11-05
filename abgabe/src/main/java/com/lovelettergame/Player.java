package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

/**
 * The Player class represents a player in the Love Letter game.
 */
public class Player {

    private String name;
    private Card hand;

    private int score;

    private boolean protectedC;

    private boolean isOut;
    private int playerID;

    /**
     * Creates a new player with the given name, initializing their score, protection status, and game status.
     *
     * @param name The name of the player.
     */
    public Player(String name, int playerID) {
        this.name = name;
        this.score = 0;
        this.protectedC = false;
        this.isOut = false;
        this.playerID = playerID;
    }

    /**
     * Checks if the player is out of the current round.
     *
     * @return true if the player is out, false otherwise.
     */
    public boolean isOut() {
        return isOut;
    }

    /**
     * Sets the player's out status.
     *
     * @param out true to mark the player as out, false to keep them in the round.
     */
    public void setOut(boolean out) {
        isOut = out;
    }

    public int getPlayerID() {
        return playerID;
    }

    /**
     * Gets the player's current score.
     *
     * @return The player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score.
     *
     * @param score The player's new score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's current hand (card).
     *
     * @return The player's current hand (card).
     */
    public Card getHand() {
        return hand;
    }

    /**
     * Sets the player's hand (card).
     *
     * @param card The new hand (card) for the player.
     */
    public void setHand(Card card) {
        this.hand = card;
    }

    /**
     * Checks if the player is protected from card effects.
     *
     * @return true if the player is protected, false otherwise.
     */
    public boolean isProtectedC() {
        return protectedC;
    }

    /**
     * Sets the player's protection status.
     *
     * @param protectedC true to protect the player, false to remove protection.
     */
    public void setProtectedC(boolean protectedC) {
        this.protectedC = protectedC;
    }

    /**
     * Plays a card and applies its effect to the player and the game.
     *
     * @param card     The card to play.
     * @param scanner  A Scanner object for user input.
     * @param players  A list of all players in the game.
     * @return The played card.
     */
    public Card playCard(Card card, Scanner scanner, List<Player> players) {
        card.effect(this, players, scanner);
        return card;
    }

    /**
     * Checks if the player holds a card with the specified hierarchy value.
     *
     * @param hierarchy The hierarchy value to check.
     * @return true if the player holds a card with the given hierarchy, false otherwise.
     */
    public boolean hasCard(int hierarchy) {
        return hand.getHierarchy() == hierarchy;
    }

    /**
     * Adds points to the player's score.
     *
     * @param roundScore The points to add to the player's score.
     */
    public void addToScore(int roundScore) {
        this.score += roundScore;
    }
}