package com.appian.deckofcards;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.EmptyStackException;
import java.util.Set;
import java.util.HashSet;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

	@Test
	public void testCreateNewDeck() {
		deck.createNewDeck();
		Set<Card> cardsSet = new HashSet<Card>();
		for(int i=0; i< 52; i++){
			boolean notExists = cardsSet.add(deck.dealOneCard());
			assertTrue(notExists);
		}
		assertEquals(deck.size(), 52);
	}

	@Test
	public void testShuffle_duplicates() {
		deck.shuffle();
		Set<Card> cardsSet = new HashSet<Card>();
		for(int i=0; i< 52; i++){
			boolean notExists = cardsSet.add(deck.dealOneCard());
			assertTrue(notExists);
		}
	}

    @Test
	public void testDealOneCard() {
		Card card = deck.dealOneCard();
		assertNotNull(card);
	}

	@Test
	public void testDealOneCard_Twice() {
		Card card = deck.dealOneCard();
		assertNotNull(card);
		Card card2 = deck.dealOneCard();
		assertNotNull(card2);
		assertFalse(card.equals(card2));
	}

    @Test
	public void testDealOneCard_53times_throws_emptystackexception() {
		for (int i = 0; i < 52; i++) {
			deck.dealOneCard();
		}

		assertThrows(EmptyStackException.class, () -> {
			deck.dealOneCard();
		});
	}
}