# Poker
# Group: SE-2218

# Team members: Yakupov Shamil, Kenes Iliias, Gashimov Khussein.
# Project Overview:
This README provides an overview of the Poker Game project, describing its purpose, objectives, and key features. The project is a command-line based poker game, implemented in Java. It simulates a simple poker game for two players with a deck of either 36 or 52 cards , depending on user choice, and Word guess game.

# Project Idea:
The project aims to create a poker game that allows two players to compete against each other. It uses a standard deck of cards and follows traditional poker hand ranking rules to determine the winner. On the other hand, we've created another word guessing game.

# Purpose of the Work:
The purpose of this project is to demonstrate a basic implementation of a poker game and a word guessing game, to show the principles of object-oriented programming, design patterns and basic Java concepts.
# Objectives of the Work:
Create a functional poker game and word guesser. Implement a deck of cards with a choice of 36 or 52 cards. Model player actions, card dealing, and hand comparisons. Apply design patterns to improve code organization. Implement a word guesser with patterns.
# Main Body: The core components of the Poker Game project are described below. The project utilizes various design patterns and includes features for playing poker.

# Card Class:
The Card class represents a playing card. It contains information about the card's suit and rank. Cards are compared using the compareTo method, and they can be displayed as strings.

# CardDeckFactory Interface:
The CardDeckFactory interface is used to create different types of card decks. Two concrete classes (PokerDeck36Factory and PokerDeck52Factory) implement this interface to create decks with 36 or 52 cards, respectively.

# ClearTerminal Class:
The ClearTerminal class provides a utility method for clearing the console terminal, ensuring a clean display during the game.

# Combinatorics Class:
The Combinatorics class generates combinations of cards, which is essential for determining poker hand ranks and comparisons.

# Game Class:
The Game class is the heart of the poker game. It controls the game flow, including deck creation, card dealing, player actions, hand comparisons, and determining the winner. The game can be played by invoking the game() method.

# Hand Class:
The Hand class represents a player's hand in poker. It includes methods for adding cards, determining the best hand type, and comparing hands.

# HandType Enum:
The HandType enum defines the various possible hand types in poker, such as Royal Flush, Straight Flush, Four of a Kind, etc. These hand types are used for ranking poker hands.

# Observer Interface:
The Observer interface is part of the Observer design pattern, allowing objects to subscribe to updates. In the project, players can observe changes in the game's table.

# Player Class:
The Player class represents a poker player, including their name, hand, bet money, and current bet. Players can add or remove bet money and observe changes on the game table.

# PokerDeck Class:
The PokerDeck class represents a deck of cards. It uses the Singleton pattern to ensure there is only one instance of the deck. It also includes methods for drawing cards and shuffling the deck.

# Table Class:
The Table class represents the poker table where community cards are placed. It also implements the Observer pattern, allowing players to observe updates on the table.

# WinnerDeterminer Class:
The WinnerDeterminer class determines the winner of a poker hand by comparing the hands of two players and the community cards on the table.

# ComputerGuesser:
This class represents the computer that attempts to guess the target word. It implements the Guesser interface and contains the logic for guessing the word.

# GuessCounterDecorator: 
This class decorates a Guesser object, counting the number of guesses made by the computer.

# Guesser:
This is an interface that defines the methods required for guessing and retrieving the current guess.

# WordGuessGame: 
The main class that sets up the game, reads the target word from the command-line argument, and orchestrates the game loop.

# GuesserAdapter:
This class adapts the ComputerGuesser to the Guesser interface.
# Conclusion:
The Poker Game project is a simple yet functional implementation of a poker game in Java. It employs object-oriented principles and design patterns to enhance code organization and reusability. The project allows players to enjoy a basic poker game and demonstrates the use of various design patterns.

# Key Points:
Uses the Singleton pattern for a deck of cards. Implementation of the Observer pattern for player notifications. Uses the factori pattern for selecting the number of cards. Includes multiple design patterns for better code organization. Wrote the following patterns for the word guesser: Decorator, Bridge, Adapter. Provides a command line interface for playing poker.
# Project Outcomes:
The project successfully creates a poker game with basic features and demonstrates the application of design patterns. Players can enjoy a simplified poker game on the console.
A ready and working word guesser.
# Challenges Faced:
Implementing and testing poker hand ranking logic.

Coordinating player actions and hand comparisons.

Ensuring clear console output during gameplay.

# Future Improvements:
There are several possible improvements for the project:

Enhancing the user interface for a more interactive experience.

Adding support for more players.

Implementing advanced poker rules and betting options.

Creating a graphical user interface (GUI) version of the game.