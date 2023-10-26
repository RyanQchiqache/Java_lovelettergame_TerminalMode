package com.lovelettergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * The Deck class represents a deck of cards used in the Love Letter game.
 */

public class Deck {
    private static final int NUM_GUARDS = 5;
    private static final int NUM_PRIESTS = 2;
    private static final int NUM_BARONS = 2;
    private static final int NUM_HANDMAIDS = 2;
    private static final int NUM_PRINCES = 2;
    private static final int NUM_KINGS = 1;
    private static final int NUM_COUNTESSES = 1;
    private static final int NUM_PRINCESSES = 1;

    private List<Card> cards;

    /**
     * Constructs a new deck of cards and adds the appropriate number of each card to the deck.
     */

    public Deck() {
        cards = new ArrayList<Card>();
        addCardsToDeck();
    }

    private void addCardsToDeck() {
        for (int i = 0; i < NUM_GUARDS; i++) {
            cards.add(new Guard());
        }
        for (int i = 0; i < NUM_PRIESTS; i++) {
            cards.add(new Priest());
        }
        for (int i = 0; i < NUM_BARONS; i++) {
            cards.add(new Baron());
        }
        for (int i = 0; i < NUM_HANDMAIDS; i++) {
            cards.add(new Handmaid());
        }
        for (int i = 0; i < NUM_PRINCES; i++) {
            cards.add(new Prince());
        }
        for (int i = 0; i < NUM_KINGS; i++) {
            cards.add(new King());
        }
        for (int i = 0; i < NUM_COUNTESSES; i++) {
            cards.add(new Countess());
        }
        for (int i = 0; i < NUM_PRINCESSES; i++) {
            cards.add(new Princess());
        }
    }
    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    /**
     * Draws a card from the deck (removes and returns the top card).
     *
     * @return The drawn Card.
     */
    public Card draw() {

        return cards.remove(0);
    }
    /**
     * Peeks at the top card of the deck without removing it.
     *
     * @return The top Card in the deck.
     */
    public Card peek() {
        return cards.get(0);
    }
    /**
     * Checks if the deck is empty.
     *
     * @return true if the deck is empty, false otherwise.
     */

    public boolean isEmpty() {
        return cards.isEmpty();
    }
    /**
     * Returns the number of cards in the deck.
     *
     * @return The number of cards in the deck.
     */

    public int size() {
        return 0;
    }
}

