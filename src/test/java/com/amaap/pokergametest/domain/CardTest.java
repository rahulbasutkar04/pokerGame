package com.amaap.pokergametest.domain;

import com.amaap.pokergame.domain.Card;
import com.amaap.pokergame.model.Rank;
import com.amaap.pokergame.model.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void shouldBeAbleToCreateCardWithRankAndSuit() {
        // Arrange
        Rank expectedRank = Rank.ACE;
        Suit expectedSuit = Suit.HEARTS;

        // Act
        Card card = new Card(expectedRank, expectedSuit);

        // Assert
        assertNotNull(card, "domain.Card should not be null");

    }

    @Test
    void shouldBeAbleToGetRankAfterCreationOfCard() {
        // Arrange
        Rank expectedRank = Rank.JACK;
        Suit suit = Suit.CLUBS;

        // Act
        Card card = new Card(expectedRank, suit);
        Rank actualRank = card.getRank();

        // Assert
        assertEquals(expectedRank, actualRank, "enump.Rank should be JACK");

    }

    @Test
    void shouldBeAbleToGetSuitAfterCreationOfCard() {
        // Arrange
        Rank rank = Rank.JACK;
        Suit ExpectedSuit = Suit.CLUBS;

        // Act
        Card card = new Card(rank, ExpectedSuit);
        Suit actualSuit = card.getSuit();

        // Assert
        assertEquals(ExpectedSuit, actualSuit, "enump.Suit  should be Clubs");

    }

}