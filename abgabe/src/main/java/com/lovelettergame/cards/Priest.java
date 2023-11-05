package com.lovelettergame.cards;

import com.lovelettergame.Card;
import com.lovelettergame.Player;

import java.util.List;
import java.util.Scanner;
/**
 * The Priest class represents a Priest card in the Love Letter game.
 * Players can use this card to look at another player's card.
 */

public class Priest extends Card {
    // Constructor for Priest card
    public Priest() {
        super("Priest", 2);
    }
    /**
     * The effect of playing the Priest card. Players can use this card to look at another player's card.
     *
     * @param currentPlayer The current player who plays the Priest card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("|                               PRIEST EFFECT                                     |");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Which player's card would you like to see? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size() || allPlayers.get(playerNum-1).equals(currentPlayer)) {
            System.out.println("Invalid player number.");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        System.out.println(targetPlayer.getName() + "'s card is the " + targetPlayer.getHand().getName() + ".");
        scanner.nextLine();
        System.out.println("---------------------------------------------------------------------------------\n");
    }


}
