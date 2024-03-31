package com.amaap.pokergame.domain.model;

import com.amaap.pokergame.domain.builder.CardBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandEvaluatorTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldIdentifyRoyalFlush() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForRoyalFlush();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.ROYAL_FLUSH, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyStraightFlush() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForStraightFlush();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.STRAIGHT_FLUSH, ranking);
    }


    @Test
    void shouldBeAbleToIdentifyFourOfAKind() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForFourOfAKind();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.FOUR_OF_A_KIND, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyFullHouse() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForFullHouse();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.FULL_HOUSE, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyFlush() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForFlush();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.FLUSH, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyStraight() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForStraight();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.STRAIGHT, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyThreeOfAKind() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForThreeOfKind();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.THREE_OF_A_KIND, ranking);
    }

    @Test
    void shouldBeAbleToIdentifyTwoPair() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForTwoPair();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.TWO_PAIR, ranking);
    }


    @Test
    void shouldBeAbleToIdentifyPair() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardFoPair();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);

        // assert
        assertEquals(HandRanking.ONE_PAIR, ranking);
    }


    @Test
    void shouldIdentifyHighCard() {
        // arrange
        HandEvaluator handEvaluator = new HandEvaluator();
        List<Card> cards = cardBuilder.getCardForHighCard();

        // act
        HandRanking ranking = handEvaluator.evaluateHand(cards);
        Card highestCard = handEvaluator.extractHighCard(cards);

        // assert
        assertEquals(HandRanking.HIGH_CARD, ranking);
        assertEquals("KING", highestCard.getRank().getName());
    }


}