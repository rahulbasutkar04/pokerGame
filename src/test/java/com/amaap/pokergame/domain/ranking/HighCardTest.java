package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.builder.CardBuilder;
import com.amaap.pokergame.domain.exception.EmptyCardException;
import com.amaap.pokergame.domain.exception.InvalidCardTypeException;
import com.amaap.pokergame.domain.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.domain.exception.cardAlreadyExistException;
import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Hand;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleIdentifyTheHighCardCategoryWhenListOfFiveCardIsPassed() {
        // arrange
        HighCard highCard = new HighCard();
        List<Card> cards = cardBuilder.getCardForHighCard();

        // act
        boolean actual = highCard.isHighCard(cards);

        // assert
        assertTrue(actual);

    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        HighCard highCard = new HighCard();
        String userInput = "AH,2D,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();

        // assert
        assertTrue(highCard.isHighCard(cards));
    }

    @Test
    void shouldBeAbleToRecognizeHighCardIfOnlyHighRankedCardsAreGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        HighCard highCard = new HighCard();
        String userInput = "AH,KD,QS,JC,QH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();

        // assert
        assertTrue(highCard.isHighCard(cards));

    }

    @Test
    void shouldBeAbleToRecognizeLowHighCardIfOnlyLowerRankedCardsAreGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        HighCard highCard = new HighCard();
        String userInput = "TH,2D,3S,5C,9H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();

        // assert
        assertTrue(highCard.isHighCard(cards));
    }

}
