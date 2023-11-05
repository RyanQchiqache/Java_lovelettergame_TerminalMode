package com.lovelettergame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * The Game class represents the Love Letter game and manages game logic.
 */
public class Game {

    private Boolean gameStarted = false;
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
    /**
     * Starts the Love Letter game, allowing players to set up their names and dealing cards to them.
     */
    public void start() {
        int playerID = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("|              LOVE LETTER GAME                   |");
        System.out.println("--------------------------------------------------");

        while (true) {
            System.out.print("Enter number of players (from 2 to 4 ) : ");
            String input = scanner.nextLine();

            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers >= 2 && numPlayers <= 4) {
                    break;
                } else {
                    System.out.println("Please enter a valid number of players (from 2 to 4).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            while (playerName.length() > 21 || playerName.length() < 1) {
                System.out.println("Player name should be 1 to 21 characters. Please try again.");
                System.out.print("Enter name for Player " + (i + 1) + " (1 to 21 characters): ");
                playerName = scanner.nextLine();
            }
            players.add(new Player(playerName, playerID));
            playerID++;
        }
        gameStarted = true;
        System.out.println("Game started!");

        System.out.println("---------------------------------------------------\n");

        explainHowToPlay();
        System.out.println("Dealing cards...");
        dealCards();
        currentPlayer = players.get(0);
        System.out.println("Enter \\help for a list of commands.");
    }

    /**
     * Deals cards to the players in the game.
     */
    private void dealCards() {
        deck.shuffle();
        for (Player player : players) {
                player.setHand(deck.draw());
             }
    }
    /**
     * Waits for user commands and processes them.
     */
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
                    showHand();
                    break;
                case "\\showScore":
                    showScore();
                    break;
                case "\\quit":
                    System.exit(0);
                    break;
                case "\\showPlayer" :
                   /* System.out.println("the current player is :" + currentPlayer.getName());*/
                    System.out.println("List of players:");
                    for (Player player : players) {
                        System.out.println("Player ID: " + player.getPlayerID() + ", Name: " + player.getName());
                    }
                    break;
                default:
                    System.out.println("Unknown command. Enter \\help for a list of commands.");
                    break;

            }
        }
    }
    /**
     * Prints a quick explanation of how the game is played.
     */

    private void explainHowToPlay() {
        // Define ANSI escape codes for text effects
        String reset = "\u001B[0m"; // Reset text formatting
        String bold = "\u001B[1m"; // Bold text
        String green = "\u001B[32m"; // Green text

        System.out.println("\n--------------------------------------------------------------------------------------------");
        System.out.println("|                                      HOW TO PLAY                                          |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(green + "Welcome to Love Letter! Here's how to play:" + reset);
        System.out.println(bold + "1. The goal is to collect tokens by winning rounds." + reset);
        System.out.println(bold + "2. Each round, you'll have a card in your hand." + reset);
        System.out.println(bold + "3. Use the \\playTurn command to play a card and try to eliminate other players." + reset);
        System.out.println(bold + "4. The player with the highest card at the end of a round wins the token for that round." + reset);
        System.out.println(bold + "5. The first player to collect enough tokens wins the game." + reset);
        System.out.println(bold + "6. Card hierarchy: Princess > Countess > King > Prince > Handmaid > Baron > Priest > Guard" + reset);
        System.out.println(bold + "7. Enjoy the game and have fun!" + reset);
        System.out.println("---------------------------------------------------------------------------------------------\n");
    }

    /**
     * Prints a list of available commands for player for help.
     */

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
    /**
     * Plays a turn in the game, allowing the current player to choose which card to play.
     *
     * @param scanner A Scanner object for user input.
     */

    private void playTurn(Scanner scanner) {
        // check if round is over
        if (deck.isEmpty()) {
            endRound(); // endRound method
            return;
        }
        Card playedCard;
        Card newCard = deck.draw();
        System.out.println("\n-------------------------------- ");
        System.out.println("|          LOVE LETTER GAME       |");
        System.out.println("|          Play Turn mode         |");
        System.out.println("-----------------------------------");
        System.out.println("Which card do you want to discard?");
        System.out.println("- Hand (enter True): " + currentPlayer.getHand().getName());
        System.out.println("- New Card (enter False): " + newCard.getName());
        System.out.println("Current Player: " + currentPlayer.getName() + " (" + currentPlayer.getPlayerID() + ")");
        System.out.println("-----------------------------------\n");

        Boolean temp = scanner.nextBoolean();
        if (temp) {
           playedCard = currentPlayer.playCard(currentPlayer.getHand(), scanner, players);
           currentPlayer.setHand(newCard);

        } else {
            playedCard = currentPlayer.playCard(newCard, scanner, players);
        }
        discardPile.add(playedCard);

        int currentPlayerIndex = players.indexOf(currentPlayer);
        do {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayer = players.get(currentPlayerIndex);
        } while (currentPlayer.isOut());
        if (players.stream().map(Player::isOut).filter(p -> !p).count() == 1L) {
            endRound();
        }
    }
    /**
     * Displays the scores of all players in the game.
     */
    public void showScore() {
        System.out.println("Score:");
        for (Player player : players) {
            System.out.println(player.getName()+"" + currentPlayer.getPlayerID() + ": " + player.getScore());
        }
    }

    /**
     * Ends the current round and determines the round winner.
     */

    private Player findPlayerWithHighestCard() {
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

        return highestPlayer;
    }
    /**
     * Awards points to the winner of the round based on the highest card hierarchy.
     *
     * @param winner The player who had the highest card hierarchy.
     */
    private void awardPointsToWinner(Player winner) {
        if (winner != null) {
            winner.addToScore(1);
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("|                       ROUND RESULTS                               |");
            System.out.println("---------------------------------------------------------------------");
            System.out.println(winner.getName() + " had the highest card hierarchy and gets a score of 1!");
            System.out.println("---------------------------------------------------------------------\n");
        }
    }
    /**
     * Displays a summary of the round, including the scores of all players.
     */
    private void displayRoundSummary() {
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("|                      ROUND OVER                                   |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Scores after this round:");
        showScore();
        System.out.println("------------------------------------------------------------------\n");

    }
    /**
     * Checks if any player has won the game based on the specified tokens needed to win.
     * If a player reaches the required score, the game is terminated and the winner is declared.
     */
    private void checkForGameWinner() {

        int tokensToWin = 7;
        switch (players.size()) {
            case 3:
                tokensToWin = 5;
                break;
            case 4:
                tokensToWin = 4;
                break;
        }

        System.out.println("Tokens to Win: " + tokensToWin);
        System.out.println("--------------------------------------------------------------------\n");
        for (Player player : players) {
            if (player.getScore() >= tokensToWin) {
                System.out.println("\n-----------------------------------------------------------------");
                System.out.println("|                         GAME OVER                               |");
                System.out.println("-------------------------------------------------------------------");
                System.out.println(player.getName() + " wins the game!");
                System.out.println("------------------------------------------------------------------\n");
                System.exit(0);
            }
        }
    }
    /**
     * Resets the round by shuffling the deck and giving each player a new card.
     */
    private void resetRound(){
        deck = new Deck();
        deck.shuffle();

        for (Player player : players) {
            if (player.isOut() ){
                player.setOut(false);
            }
            player.setHand(deck.draw());
        }
    }
    /**
     * Ends the current round by determining the highest card holder, awarding points, displaying the summary,
     * checking for a game winner, and resetting the round for the next iteration.
     */
    private void endRound (){
        Player highestPlayer = findPlayerWithHighestCard();
        awardPointsToWinner(highestPlayer);
        displayRoundSummary();
        checkForGameWinner();
        resetRound();
    }
    /**
     * Displays the current player's hand if the game has started.
     * Otherwise, it notifies that the game has not started yet.
     */
    public void showHand() {
        if (gameStarted) {
            System.out.println("The player " + currentPlayer.getName() + " hand is :  " + currentPlayer.getHand().getName());
        } else {
            System.out.println("The game has not started yet.");
        }
    }
    /**
     * Main method to start the Love Letter game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.waitForCommand();

    }


}

