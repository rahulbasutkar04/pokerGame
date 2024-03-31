package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.builder.CardBuilder;
import com.amaap.pokergame.domain.exception.EmptyCardException;
import com.amaap.pokergame.domain.exception.InvalidCardTypeException;
import com.amaap.pokergame.domain.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.domain.exception.cardAlreadyExistException;
import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Hand;
import com.amaap.pokergame.domain.model.StraightFlushCheck;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullHouseTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIdentifyFullOfCardRank() {
        // arrange
        FullHouse fullHouse = new FullHouse();
        List<Card> cards = cardBuilder.getCardForFullHouse();

        // act
        boolean actual = fullHouse.isFullHouse(cards);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        FullHouse fullHouse = new FullHouse();
        String userInput = "QH,QD,QC,4H,4C";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();

        // assert
        assertTrue(fullHouse.isFullHouse(cards));
    }

    @Test
    void shouldNotBeAbleToIdentifyFlushCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        StraightFlushCheck flush = new Flush();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();

        // assert
        assertFalse(flush.isStraightFlushCheck(cards));
    }


    @Test
    void shouldBeAbleToIdentifyFullHouseIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        Hand hand = new Hand();
        FullHouse fullHouse = new FullHouse();
        String userInput = "4D,QD,QC,4H,QH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        hand.start();
        List<Card> cards = hand.getUserHand();

        // assert
        assertTrue(fullHouse.isFullHouse(cards));
    }
}
