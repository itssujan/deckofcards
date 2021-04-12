package com.appian.deckofcards;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final int CARDS_IN_COMPLETED_DECK = 52;
	private Card[] cards;

    private int cardsDealt = 0;

	public Deck() {
	 createNewDeck();
	}

    /**
     * Creates a new deck
     */
	void createNewDeck() {
        cards = new Card[52];
        int cardCount = 0;
		for (Rank rank : EnumSet.allOf(Rank.class)) {
			for (Suit suit : EnumSet.allOf(Suit.class)) {
				cards[cardCount] = new Card(rank, suit);
                cardCount++;
			}
		}
        cardsDealt = 0;
	}

    /**
     * Shuffles the deck. theres a small chance of the card shuffling at this own position
     */
	public void shuffle() {
        for ( int i = cards.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        cardsDealt = 0;
	}

    /**
     *  Returns top of the card. Throws EmptyStackException if all the cards in the deck have already been dealt
     * @return
     */
	public Card dealOneCard() {
        if(cardsDealt == cards.length)
		    throw new EmptyStackException();
        cardsDealt++;
        return cards[cardsDealt - 1];        
	}

	void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}

    public int size() {
        return cards.length;
    }

}