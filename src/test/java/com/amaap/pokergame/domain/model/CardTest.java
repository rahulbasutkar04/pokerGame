package com.amaap.pokergame.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CardTest {
    @Test
    void shouldBeAbleToCreateCardWithRankAndSuit() {
        // arrange
        Rank expectedRank = Rank.ACE;
        Suit expectedSuit = Suit.HEARTS;

        // act
        Card card = new Card(expectedRank, expectedSuit);

        // assert
        assertNotNull(card);
    }

    @Test
    void shouldBeAbleToGetRankAfterCreationOfCard() {
        // arrange
        Rank expectedRank = Rank.JACK;
        Suit suit = Suit.CLUBS;

        // act
        Card card = new Card(expectedRank, suit);
        Rank actualRank = card.getRank();

        // assert
        assertEquals(expectedRank, actualRank);

    }

    @Test
    void shouldBeAbleToGetSuitAfterCreationOfCard() {
        // arrange
        Rank rank = Rank.JACK;
        Suit ExpectedSuit = Suit.CLUBS;

        // act
        Card card = new Card(rank, ExpectedSuit);
        Suit actualSuit = card.getSuit();

        // assert
        assertEquals(ExpectedSuit, actualSuit);
    }

    @Test
    void ShouldBeAblToTestEqualsAndHashCode() {
        // arrange
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);

        // act & assert
        assertEquals(card1, card2);
        assertEquals(card1.hashCode(), card2.hashCode());

    }

    @Test
    void shouldBeAbleToTestEqualsAndHashCode() {
        // arrange
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);

        // act & assert
        assertEquals(card1, card2);
        assertEquals(card1.hashCode(), card2.hashCode());
    }
}