package com.lovelettergame;

import java.util.List;
import java.util.Scanner;

public abstract class Card {
    private String name;
    private int hierarchy;

    public Card(String name, int hierarchy) {
        this.name = name;
        this.hierarchy = hierarchy;
        
    }
    // static method to return a Card based on cardNum
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

    // abstract method to be implemented by each card subclass
    public abstract void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner);

    // prompts user to choose a card to play, and returns the chosen card
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
