package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class Handmaid extends Card {
    // Constructor for Handmaid card
    public Handmaid() {
        super("Handmaid", 4);
    }

    // The player who plays this card is immune to all effects until their next turn.
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        currentPlayer.setProtectedC(true);
        System.out.println(currentPlayer.getName() + " is protected by the Handmaid until the start of their next turn.");

        // Check if all other players are protected
        boolean allPlayersProtected = true;
        for (Player player : allPlayers) {
            if (!player.equals(currentPlayer) && !player.isProtectedC()) {
                allPlayersProtected = false;
                break;
            }
        }

        // If all other players are protected, the active player must choose themselves for the effect of a card if possible
        if (allPlayersProtected) {
            Card chosenCard = chooseCardToPlay(scanner);// to do
            if (chosenCard != null) {
                chosenCard.effect(currentPlayer, allPlayers, scanner);
            }
        }
        scanner.nextLine();
    }


}

