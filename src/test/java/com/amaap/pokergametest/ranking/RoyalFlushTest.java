package com.amaap.pokergametest.ranking;

import com.amaap.pokergame.domain.Card;
import com.amaap.pokergame.exception.EmptyCardException;
import com.amaap.pokergame.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.Rank;
import com.amaap.pokergame.model.Suit;
import com.amaap.pokergame.ranking.RoyalFlush;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoyalFlushTest {


    @Test
    void shouldAbleToCheckIfUserHasTheFiveCardsOrNot() throws EmptyCardException, InvalidNumberOfCardException {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // act
        royalFlush.checkRankingFor(cards);
        // assert
        assertEquals(5, cards.size());
    }

    @Test
    void shouldAbleToThrowExceptionIfEmptyListOfCardIsGiven() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        // act & assert
        assertThrows(EmptyCardException.class, () -> {
            royalFlush.checkRankingFor(cards);
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfMorThanFiveCardIsGiven() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> royalFlush.checkRankingFor(cards));
    }

    @Test
    void shouldBeAbleThrowExceptionForLessThanFiveCards() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> royalFlush.checkRankingFor(cards));
    }


    @Test
    void shouldBeAbleToIdentifyRoyalFlush() throws EmptyCardException, InvalidNumberOfCardException {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.JACK, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));

        // act & assert
        assertTrue(royalFlush.checkRankingFor(cards), "Expected Royal Flush");
    }


}
