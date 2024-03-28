package com.amaap.pokergametest.ranking;

import com.amaap.pokergame.domain.Card;
import com.amaap.pokergame.exception.EmptyCardException;
import com.amaap.pokergame.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.Rank;
import com.amaap.pokergame.model.Suit;
import com.amaap.pokergame.ranking.Flush;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlushTest {

    @Test
    void shouldBeAbleToCheckIfUserHasTheFiveCardsOrNot() throws InvalidNumberOfCardException, EmptyCardException {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // act
        flush.checkRankingFor(cards);
        // assert
        assertEquals(5, cards.size());
    }

    @Test
    void shouldBeAbleToIdentifyFlush() throws EmptyCardException, InvalidNumberOfCardException {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        // act & assert
        assertTrue(flush.checkRankingFor(cards), "Expected flush");
    }

    @Test
    void shouldNotIdentifyFlushIfDifferentSuits() throws EmptyCardException, InvalidNumberOfCardException {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        // act & assert
        assertFalse(flush.checkRankingFor(cards), "Expected no flush");
    }

    @Test
    void shouldBeABleToThrowExceptionForEmptyCardList() {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        // act & Assert
        assertThrows(EmptyCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldBeAbleThrowExceptionForLessThanFiveCards() {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldThrowExceptionForMoreThanFiveCards() {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> flush.checkRankingFor(cards));
    }


}
