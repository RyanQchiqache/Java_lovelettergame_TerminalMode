package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class Prince extends Card {
    // Constructor for Prince card
    public Prince() {
        super("Prince", 5);
    }

    // Choose a player (including yourself) to discard their hand and draw a new card
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("Which player would you like to target? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size()) {
            System.out.println("Invalid player number. Please enter a number 1-" + allPlayers.size() + ".");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        if (targetPlayer.getHand().getHierarchy() == 8 ) {
            targetPlayer.setOut(true);
            System.out.println(targetPlayer.getName() + " discarded the Princess and is out of the round.");
        } else {
            targetPlayer.getHand();// to do !!
        }
        scanner.nextLine();
    }

}

