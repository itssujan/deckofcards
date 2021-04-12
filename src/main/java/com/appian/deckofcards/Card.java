package com.appian.deckofcards;

public class Card {
    
    private final Rank rank;
	private final Suit suit;

	/**
	 * Cards are only accessible to the Deck
	 * @param rank
	 * @param suit
	 */
    Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Gives rank of the card
	 * @return
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Gives suit of the card
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	/**
	 *  To consider both suit and rank while checking equality of a card
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card card = (Card) obj;
		if (rank != card.rank) {
			return false;
		}
		if (suit != card.suit) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return rank.getDisplay() + " of " + suit;
	}

}