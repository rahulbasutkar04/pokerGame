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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightFlushTest {

    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsStraightFlush() {
        // arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = cardBuilder.getCardForStraightFlush();

        // act
        boolean actual = straightFlush.isStraightFlushCheck(cards);

        // assert
        assertTrue(actual);

    }

    @Test
    void shouldNotBeAbleToIdentifyStraightFlushCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        StraightFlush straightFlush = new StraightFlush();
        String userInput = "AH,2D,3S,2C,2H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);

        // assert
        assertFalse(straightFlush.isStraightFlushCheck(cardList));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
       // arrange
        Hand hand = new Hand();
        StraightFlush straightFlush = new StraightFlush();
        String userInput = "3H,4H,5H,6H,7H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);

        // assert
        assertTrue(straightFlush.isStraightFlushCheck(cardList));
    }

}
