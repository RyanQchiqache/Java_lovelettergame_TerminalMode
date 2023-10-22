package com.lovelettergame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private int numPlayers;
    private List<Player> players;
    private Player currentPlayer;
    private Deck deck;
    private ArrayList<Card> discardPile;
    private int numCardsInDeck;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        players = new LinkedList<>();
        deck = new Deck();
        discardPile = new ArrayList<>();
        numCardsInDeck = deck.size();

    }

    // method to start the game
    public void start() {
        System.out.print("Enter number of players (2-4): ");
        numPlayers = scanner.nextInt(); // read the number of players
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName)); // creates a new player object with the entered name
        }
        System.out.println("Dealing cards...");
        dealCards();
        currentPlayer = players.get(0);
        System.out.println("Enter \\help for a list of commands.");
    }

    // method to deal cards to players
    private void dealCards() {
        deck.shuffle();
        for (Player player : players) {
                player.setHand(deck.draw());
             }
    }

    private void waitForCommand() {
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            switch (input) {
                case "\\help":
                    printHelp();
                    break;
                case "\\start":
                    start();
                    break;
                case "\\playTurn":
                    playTurn(scanner);
                    break;
                case "\\showHand":
                    for (Player player : players) {
                        System.out.println("The player " + player.getName() + " hand is :  " + player.getHand().getName()
                                + " Out of the Round : " + player.isOut());
                    }
                    break;
                case "\\showScore":
                    showScore();
                    break;
                case "\\quit":
                    System.exit(0);
                    break;
                case "\\showPlayer" :
                    System.out.println("the current player is :" + currentPlayer.getName());
                    break;
                default:
                    System.out.println("Unknown command. Enter \\help for a list of commands.");
                    break;

            }
        }
    }

    private void printHelp() {
        System.out.println("List of commands:");
        System.out.println("\\help - Show this list of commands.");
        System.out.println("\\start - Start a new game.");
        System.out.println("\\playTurn - Play a card from your hand.");
        System.out.println("\\showHand - Shows the card in each player's hand, with the player status.");
        System.out.println("\\showScore - Show the score for each player.");
        System.out.println("\\showPlayer - Show the current player." );
        System.out.println("\\quit - Quit the game.");
    }

    private void playTurn(Scanner scanner) {
        // check if round is over
        if (deck.isEmpty()) {
            endRound(); // endRound method
            return;
        }
        Card playedCard;
        Card newCard = deck.draw();
        System.out.println(" Which card do you want to discard ? - Hand ( True ) :" + currentPlayer.getHand().getName()
                +" " +" or the new Card ( False ) : " + newCard.getName() + " currPlayer : "+ currentPlayer.getName());
        Boolean temp = scanner.nextBoolean();
        if (temp) {
           playedCard = currentPlayer.playCard(currentPlayer.getHand(), scanner, players);
           currentPlayer.setHand(newCard);

        } else {
            playedCard = currentPlayer.playCard(newCard, scanner, players);
        }

        discardPile.add(playedCard);

        // move to next player
        int currentPlayerIndex = players.indexOf(currentPlayer);
        do {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayer = players.get(currentPlayerIndex);
        } while (currentPlayer.isOut());
        if (players.stream().map(Player::isOut).filter(p -> !p).count() == 1L) {
            endRound();
        }
    }



    public void showScore() {
        System.out.println("Score:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    // method to end the current round

    private void endRound() {
        // Find player with the highest hierarchy card
        Player highestPlayer = null;
        int highestHierarchy = 0;
        for (Player player : players) {
            if (!player.isOut()) {
                int hierarchy = player.getHand().getHierarchy();
                if (hierarchy > highestHierarchy) {
                    highestHierarchy = hierarchy;
                    highestPlayer = player;
                }
            }
        }

        // Add 1 to the score of the player with the highest hierarchy card
        if (highestPlayer != null) {
            highestPlayer.addToScore(1);
            System.out.println(highestPlayer.getName() + " had the highest card hierarchy and gets a score of 1!");
        }


        // Print "Round over. Scores:" to the console
        System.out.println("Round over. Scores:");

        // Call the "showScore" method to display the updated scores
        showScore();

        // determines the number of tokens required to win based on the number of players
        int tokensToWin = 7;
        switch(players.size()) {
            case 3:
                tokensToWin = 5;
                break;
            case 4:
                tokensToWin = 4;
                break;
        }

// checks if any player has reached the required number of tokens to win
        for (Player player : players) {
            if (player.getScore() >= tokensToWin) {
                System.out.println(player.getName() + " wins the game!");
                // add any additional logic here for what happens when the game is won
                System.exit(0);
            }
        }
        for (Player player : players) {
            if (player.isOut() ){
                player.setOut(false);
            }
        }


        // Reset the deck
        deck = new Deck();
    }


     public static void main(String[] args) {
        Game game = new Game();
        game.waitForCommand();

    }


}

