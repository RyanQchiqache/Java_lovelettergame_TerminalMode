package com.lovelettergame.cards;

import com.lovelettergame.Card;
import com.lovelettergame.Player;

import java.util.List;
import java.util.Scanner;
/**
 * The Guard class represents a Guard card in the Love Letter game.
 * Players can use this card to guess another player's card. If they guess correctly, the targeted player is out of the round.
 */
public class Guard extends Card {
    // Constructor for Guard card
    public Guard() {
        super("Guard", 1);
    }


    /**
     * The effect of playing the Guard card. Players can guess another player's card. If the guess is correct, the targeted
     * player is eliminated from the round. If the guess is incorrect, nothing happens.
     *
     * @param currentPlayer The current player who plays the Guard card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    @Override
    public  void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("|                         GUARD EFFECT                                 |");
        System.out.println("------------------------------------------------------------------------");
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
        System.out.println("-------------------------------------------------------------------------\n");

    }




}
