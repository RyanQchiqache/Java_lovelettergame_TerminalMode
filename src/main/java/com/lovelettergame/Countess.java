package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class Countess extends Card {
    // Constructor for Countess card
    public Countess() {
        super("Countess", 7);
    }

    // If a player holds both this card and either the King or Prince card, they must discard this card.
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        if (currentPlayer.hasCard(6) || currentPlayer.hasCard(5)) {
            System.out.println("You must discard the Countess card.");
        }
        scanner.nextLine();
    }

}

