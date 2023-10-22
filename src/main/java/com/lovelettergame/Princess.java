package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class Princess extends Card {
    // Constructor for Princess card
    public Princess() {
        super("Princess", 8);
    }

    // If you discard this card, you are out of the round.
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("You must discard your Princess card. You are out of the round.");
        currentPlayer.setOut(true);
        scanner.nextLine();
    }
}

