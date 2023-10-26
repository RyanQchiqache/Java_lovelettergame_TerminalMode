package com.lovelettergame;

import java.util.List;
import java.util.Scanner;
/**
 * The Princess class represents a Princess card in the Love Letter game.
 * If a player discards this card, they are automatically eliminated from the round.
 */
public class Princess extends Card {
    // Constructor for Princess card
    public Princess() {
        super("Princess", 8);
    }

    /**
     * The effect of playing the Princess card. If a player discards this card, they are automatically eliminated from the round.
     *
     * @param currentPlayer The current player who plays the Princess card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */

    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("You must discard your Princess card. You are out of the round.");
        currentPlayer.setOut(true);
        scanner.nextLine();
    }
}

