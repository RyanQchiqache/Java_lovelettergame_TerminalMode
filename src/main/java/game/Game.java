package game;

import java.util.Scanner;


public class Game {
    private int numPlayers;
    private Player[] players;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);

    }

    // method to start the game
    public void start() {
        System.out.print("Enter number of players (2-4): ");
        numPlayers = scanner.nextInt();
        scanner.nextLine();
        players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for src.main.java.game.Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName); // creates a new player object with the entered name
        }
        System.out.println("Dealing cards...");
        System.out.println("Enter \\help for a list of commands.");
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
                case "\\playCard":
                    currentPlayer.playCard();

                    break;
                case "\\showHand":
                    System.out.println("your hand will be programmed next milestone");

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
        System.out.println("\\playCard - Play a card from your hand.");
        System.out.println("\\showHand - Shows the card in each player's hand, with the player status.");
        System.out.println("\\showScore - Show the score for each player.");
        System.out.println("\\showPlayer - Show the current player." );
        System.out.println("\\quit - Quit the game.");
    }

    public void showScore() {
        System.out.println("Score:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }



    public static void main(String[] args) {
        Game game = new Game();
        game.waitForCommand();

    }



}
