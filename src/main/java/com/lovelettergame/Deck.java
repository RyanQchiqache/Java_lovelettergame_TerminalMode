package com.lovelettergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {

        return cards.remove(0);
    }

    public Card peek() {
        return cards.get(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return 0;
    }
}

