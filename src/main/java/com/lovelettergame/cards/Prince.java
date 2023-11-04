package com.lovelettergame.cards;

import com.lovelettergame.Card;
import com.lovelettergame.Player;

import java.util.List;
import java.util.Scanner;
/**
 * The Prince class represents a Prince card in the Love Letter game.
 * Players can use this card to choose a player, including themselves, to discard their hand and draw a new card.
 */

public class Prince extends Card {
    public Prince() {
        super("Prince", 5);
    }

    /**
     * The effect of playing the Prince card. Players can choose a player (including themselves) to discard their hand and draw a new card.
     * If the targeted player discards the Princess card, they are eliminated from the round.
     *
     * @param currentPlayer The current player who plays the Prince card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("|                               PRINCE EFFECT                                     |");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Which player would you like to target? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size()) {
            System.out.println("Invalid player number.");
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
        System.out.println("------------------------------------------------------------------------------------\n");
    }

}

