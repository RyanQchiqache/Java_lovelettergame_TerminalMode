package com.lovelettergame;

import java.util.List;
import java.util.Scanner;
/**
 * The Card class represents a card in the Love Letter game.
 */

public abstract class Card {
    private String name;
    private int hierarchy;

    /**
     * Creates a new Card with the specified name and hierarchy.
     *
     * @param name      The name of the card.
     * @param hierarchy The hierarchy value of the card.
     */

    public Card(String name, int hierarchy) {
        this.name = name;
        this.hierarchy = hierarchy;
        
    }
    /**
     * A static method to return a Card based on a card number.
     *
     * @param cardNum The card number (1-8) for which to get the corresponding card.
     * @return The Card object corresponding to the given card number.
     */
    protected static Card getCard(int cardNum) {
        switch (cardNum) {
            case 1:
                return new Guard();
            case 2:
                return new Priest();
            case 3:
                return new Baron();
            case 4:
                return new Handmaid();
            case 5:
                return new Prince();
            case 6:
                return new King();
            case 7:
                return new Countess();
            case 8:
                return new Princess();
            default:
                return null;
        }
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(int hierarchy) {
        this.hierarchy = hierarchy;
    }

    /**
     * An abstract method to be implemented by each card subclass, defining the effect of playing the card.
     *
     * @param currentPlayer The current player who plays the card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    public abstract void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner);

    /**
     * Prompts the user to choose a card to play and returns the chosen card.
     *
     * @param scanner A Scanner object for user input.
     * @return The chosen Card to play.
     */
    public Card chooseCardToPlay(Scanner scanner) {
        int cardNum;
        boolean validInput = false;
        Card chosenCard = null;

        // Continue to prompt user until valid input is received
        while (!validInput) {
            System.out.print("Choose a card to play (1-8): ");
            cardNum = scanner.nextInt();
            chosenCard = getCard(cardNum);

            // Check if chosen card is valid
            if (chosenCard != null && chosenCard != this) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please choose a different card.");
            }
        }

        return chosenCard;
    }



}
