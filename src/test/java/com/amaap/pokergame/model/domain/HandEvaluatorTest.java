package com.amaap.pokergame.model.domain;

import com.amaap.pokergame.model.util.HandRanking;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandEvaluatorTest {

    @Test
    void shouldIdentifyRoyalFlush() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.JACK, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.ROYAL_FLUSH, ranking);
    }

    @Test
    void shouldBeABleToIdentifyStraightFlush() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
        cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
        cards.add(new Card(Rank.NINE, Suit.CLUBS));
        cards.add(new Card(Rank.TEN, Suit.CLUBS));
        cards.add(new Card(Rank.JACK, Suit.CLUBS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.STRAIGHT_FLUSH, ranking);
    }


    @Test
    void shouldBeAbleToIdentifyFourOfAKind() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.FOUR_OF_A_KIND, ranking);
    }

    @Test
    void shouldIBeAbleToIdentifyFullHouse() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.CLUBS));
        cards.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Rank.SEVEN, Suit.SPADES));
        cards.add(new Card(Rank.SEVEN, Suit.HEARTS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.FULL_HOUSE, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyFlush() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.FLUSH, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyStraight() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.CLUBS));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.STRAIGHT, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyThreeOfAKind() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
        cards.add(new Card(Rank.EIGHT, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.HEARTS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.THREE_OF_A_KIND, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyTwoPair() {
        //arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
        cards.add(new Card(Rank.EIGHT, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.HEARTS));

        //act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        //assert
        assertEquals(HandRanking.TWO_PAIR, ranking);
    }


    @Test
    void shouldBeAbleToIdentifyFullHouse() {
        // Arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.DIAMONDS));
        cards.add(new Card(Rank.SIX, Suit.CLUBS));
        cards.add(new Card(Rank.NINE, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.HEARTS));

        // Act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // Assert
        assertEquals(HandRanking.FULL_HOUSE, ranking);

    }

}