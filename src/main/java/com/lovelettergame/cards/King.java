package com.lovelettergame.cards;

import com.lovelettergame.Card;
import com.lovelettergame.Player;

import java.util.List;
import java.util.Scanner;
/**
 * The King class represents a King card in the Love Letter game.
 * Players can use this card to trade hands with another player of their choice.
 */

public class King extends Card {
    // Constructor for King card
    public King() {
        super("King", 6);
    }
    /**
     * The effect of playing the King card. Players can trade hands with another player of their choice.
     *
     * @param currentPlayer The current player who plays the King card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("|                           KING EFFECT                                    |");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Which player would you like to trade hands with? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size() || allPlayers.get(playerNum-1).equals(currentPlayer)) {
            System.out.println("Invalid player number.");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        Card tempCard = targetPlayer.getHand();
        targetPlayer.setHand(currentPlayer.getHand());
        currentPlayer.setHand(tempCard);
        scanner.nextLine();
        System.out.println("------------------------------------------------------------------------------\n");
    }


}

