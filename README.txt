MINI PROJECT-BLACKJACK

Project overview
Blackjack is the American variant of a globally popular banking game known as Twenty-One.It is a comparing card game between one or more players and a dealer, where each player in turn competes against the dealer. Players do not compete against each other. It is played with one or more decks of 52 cards, and is the most widely played casino banking game in the world.The objective of the game is to beat the dealer in one of the following ways:

Get 21 points on the player's first two cards (called a "blackjack" or "natural"), without a dealer blackjack;
Reach a final score higher than the dealer without exceeding 21; or
Let the dealer draw additional cards until their hand exceeds 21.
Players are each dealt two cards initially.
Project Description
There are four different files
1)Cards.java
2)Deck.java
3)Player.java
4)Blacjack.java

File Description 

1)Cards.java

The file Cards.java consists of the a public class called Cards which contains two private variables value(Number on the card/face card) and suit,one constructor to initialize the variables
and two functions getVal()(return type : int)and getsuit()
(return type : int) to return their values.

2)Deck.java
The file Deck.java consists of a public class called Deck.
A constructor with one argument asking for the number of Decks the game should be played with and initializing all the cards of all the decks.
Two functions shuffleDeck()(return type : void)and Drawcard()
(return type : Card object) to shuffle all the cards present in the deck into some random order and a function drawcard() in order for the user to be dealt cards by the dealer.
3)Player.java
The file Player.java consists of an arraylist called player to store the information of the cards. 
It consists of a private variable called score,and a constrcutor to initialize the score to zero.
It also consists of 4 different functions
i)getcard()
Thi function draws one card from the list and gives it to the player. 
return type: an object card C is returned
ii)calcscore()
In order to calculate the score of the user after each turn.
return type: void
iii)Calcscored()
In order to calculate the score of the dealer after each turn..
This function actually acts as another player.
return type: void
Note: The Dealer plays Smart.
iv)getscore()
In order to return the score(Either player or Dealer).
return type : int 
4)Blackjack.java
This file consists of a function called showcards() (return type : void)
in order to make a card like visual and display it on the screen after each turn.
This class also consists of the Main function where all other functions are called to execute the program.
It offers the player options on whether he would like to continue playing or stand, and calls functions accordingly to proceed and exit the game finally.

The class Blackjack has the main Function.

Note: Player,card and Deck are under a Package called BlackJack and the file BlackJack imports the package BlackJack.
Note: All files also import the  package java.util.*.
