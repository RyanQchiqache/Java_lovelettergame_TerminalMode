package com.lovelettergame;

import java.util.List;
import java.util.Scanner;


public class Priest extends Card {
    // Constructor for Priest card
    public Priest() {
        super("Priest", 2);
    }

    // Look at another player's card
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("Which player's card would you like to see? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size() || allPlayers.get(playerNum-1).equals(currentPlayer)) {
            System.out.println("Invalid player number. Please enter a number 1-" + allPlayers.size() + ".");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        System.out.println(targetPlayer.getName() + "'s card is the " + targetPlayer.getHand().getName() + ".");
        scanner.nextLine();
    }


}
