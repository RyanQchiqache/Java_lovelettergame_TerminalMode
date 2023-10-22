# Love_Letter_Rq


A Java implementation of the Love Letter game using Maven as a build tool.
***
## Description

The Love Letter game is a card game where players try to eliminate each other and be the last player standing. The game is played with a deck of 16 cards, with each card having a unique ability.

Each player starts with one card in their hand. On their turn, a player draws a card and then plays one card, using its ability to try and eliminate the other players. If a player is eliminated, they are out of the round and cannot play any more cards until the round is over.

The round ends when there is only one player left, or the deck is empty. The player with the highest hierarchy card in their hand at the end of the round gets a score of 1. If two or more players have the same highest hierarchy card, they each get a score of 1.

The game ends when a player reaches a predetermined number of scores. In this implementation, the number of scores required to win is determined by the number of players:

- 2 players: 7 scores to win

- 3 players: 5 scores to win

- 4 players: 4 scores to win


## Getting Started
To play the Love Letter Game, you will need:

- 2 to 4 players
## Commands
The following commands are available:

- \help: Shows a list of available commands.

- \start: Starts a new game.

- \playTurn: Plays a turn in the game.

- \showHand: Shows the card in each player's hand, with the status (out of the current round!).

- \showScore: Shows the current score for each player.

- \showPlayer: Show the current player.

- \quit: Quits the game.

## Card Abilities
Each card in the Love Letter Game has a unique ability. Here's a quick rundown of each card:

- Guard (x5): Guess the card of another player. If you guess correctly, that player is eliminated from the round.

- Priest (x2): Look at another player's card.

- Baron (x2): Compare your card with another player's card. The player with the lower ranking card is eliminated.

- Handmaid (x2): Protect yourself from other player's abilities until your next turn.

- Prince (x2): Choose a player (including yourself) to discard their card and draw a new one.

- King (x1): Trade your card with another player's card.

- Countess (x1): If you have a King or Prince card in your hand, you must play the Countess.

- Princess (x1): If you play this card, you are eliminated from the round.

## How to start the game
To play the game, run the love_letter_rq.jar file using the command:
```
java -jar love_letter_rq.jar  
```
The game will prompt you for the number of players, and then for the name of each player. Once all players have been named, the game will start and prompt each player for their turn.


## Implementation
- The Game class handles the main logic of the game. It keeps track of the players, the deck of cards, and the discard pile. It also handles the input/output for the game.

- The Player class represents a player in the game. Each player has a name, a hand of cards, and a score.

- The Card class represents a card in the game. Each card has a name, a rank, and an effect.

- The Deck class represents the deck of cards in the game. It contains methods to shuffle the deck and draw cards from the deck.

## Links
- [ ] [Description of the game (pdf)](http://alderac.com/wp-content/uploads/2017/11/Love-Letter-Premium_Rulebook.pdf)


