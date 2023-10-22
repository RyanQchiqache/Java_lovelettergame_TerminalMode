package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public class Guard extends Card {
    // Constructor for Guard card
    public Guard() {
        super("Guard", 1);
    }

    // Guess a player's card. If you are correct, that player is out of the round.
    @Override
    public  void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("Which player would you like to guess? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size() || allPlayers.get(playerNum-1).equals(currentPlayer)) {
            System.out.println("Invalid player number. Please enter a number 1-" + allPlayers.size() + ".");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        System.out.println("Which card would you like to guess? (Enter a number 1-8)");
        int cardNum = scanner.nextInt();
        while (cardNum < 1 || cardNum > 8) {
            System.out.println("Invalid card number. Please enter a number 1-8.");
            cardNum = scanner.nextInt();
        }
        if (targetPlayer.hasCard(cardNum)) {
            targetPlayer.setOut(true);
            System.out.println("You correctly guessed " + targetPlayer.getName() + "'s card! They are out of the round.");
        } else {
            System.out.println("You guessed incorrectly. Nothing happens.");
        }
        scanner.nextLine();

    }




}
