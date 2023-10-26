package com.lovelettergame;

import java.util.List;
import java.util.Scanner;
/**
 * The Countess class represents a Countess card in the Love Letter game.
 * If a player holds both this card and either the King or Prince card, they must discard this card.
 */

public class Countess extends Card {

    public Countess() {
        super("Countess", 7);
    }

    /**
     * The effect of playing the Countess card. If a player holds both this card and either the King or Prince card,
     * they must discard this card.
     *
     * @param currentPlayer The current player who plays the Countess card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        if (currentPlayer.hasCard(6) || currentPlayer.hasCard(5)) {
            System.out.println("You must discard the Countess card.");
        }
        scanner.nextLine();
    }

}

