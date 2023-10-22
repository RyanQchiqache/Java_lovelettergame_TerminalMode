package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class King extends Card {
    // Constructor for King card
    public King() {
        super("King", 6);
    }

    // Trade hands with another player of your choice
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("Which player would you like to trade hands with? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size() || allPlayers.get(playerNum-1).equals(currentPlayer)) {
            System.out.println("Invalid player number. Please enter a number 1-" + allPlayers.size() + ".");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        Card tempCard = targetPlayer.getHand();
        targetPlayer.setHand(currentPlayer.getHand());
        currentPlayer.setHand(tempCard);
        scanner.nextLine();
    }


}

