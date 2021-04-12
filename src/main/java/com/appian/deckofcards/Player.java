package com.appian.deckofcards;

/**
 * Executor class that shuffles a deck and dealsOneCard for 53 times in this case
 */
public class Player {

    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println("Shuffling the cards");
        deck.shuffle();
        System.out.println("Printing shuffled cards");
        deck.printDeck();
        
        System.out.println("*** Starting to deal cards ***");
        for(int i=0; i< 53; i++) {
            System.out.println("Dealt : "+deck.dealOneCard());
        }
    }
}