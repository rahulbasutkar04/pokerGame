package com.amaap.pokergame.model.pokergame.model.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Test
    void shouldAbleToInitialiseDeckWithAllCards() {
        //arrange
        DeckOfCards deck = new DeckOfCards();

        //act
        List<Card> cards = deck.getCards();

        //assert
        assertEquals(52, cards.size());
    }


    @Test
    void shouldAbleToAssignTheFiveCardsToUser() {
        // arrange
        DeckOfCards deck = new DeckOfCards();
        Player user = new Player();

        // act
        deck.assignTheFiveCardsToUser(user);
        List<Card> userHand = user.getHand();

        // assert
        assertEquals(5, userHand.size(), "User should have 5 cards in hand only");
        assertTrue(deck.getCards().size() >= 47, "Deck should have at least 47 cards remaining after assignment of card to player");
    }

    @Test
    void shouldAbleToShuffleTheCards() {
        //arrange
        DeckOfCards deck1 = new DeckOfCards();
        DeckOfCards deck2 = new DeckOfCards();
        //act
        deck1.shuffle();
        deck2.shuffle();
        //assert
        assertNotEquals(deck1.getCards(), deck2.getCards(), "Decks should be shuffled differently");
    }


}