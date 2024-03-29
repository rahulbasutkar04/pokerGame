package com.amaap.pokergame.model.domain;

import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void shouldBeAbleToCreateCardWithRankAndSuit() {
        //arrange
        Rank expectedRank = Rank.ACE;
        Suit expectedSuit = Suit.HEARTS;
        //act
        Card card = new Card(expectedRank, expectedSuit);
        //assert
        assertNotNull(card);
    }
    @Test
    void shouldBeAbleToGetRankAfterCreationOfCard() {
        //arrange
        Rank expectedRank = Rank.JACK;
        Suit suit = Suit.CLUBS;

        //act
        Card card = new Card(expectedRank, suit);
        Rank actualRank = card.getRank();

        //assert
        assertEquals(expectedRank, actualRank);

    }

    @Test
    void shouldBeAbleToGetSuitAfterCreationOfCard() {
        //arrange
        Rank rank = Rank.JACK;
        Suit ExpectedSuit = Suit.CLUBS;

        //act
        Card card = new Card(rank, ExpectedSuit);
        Suit actualSuit = card.getSuit();

        //assert
        assertEquals(ExpectedSuit, actualSuit);

    }

}