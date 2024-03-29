package com.amaap.pokergame.model.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


}