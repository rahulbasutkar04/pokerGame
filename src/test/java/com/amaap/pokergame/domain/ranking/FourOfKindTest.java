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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourOfKindTest {

    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsFourOfKind() {
        //arrange
        FourOfKind fourOfKind = new FourOfKind();
        List<Card> cards = cardBuilder.getCardForFourOfAKind();

        //act
        boolean actual = fourOfKind.isFourOfKind(cards);

        //assert
        assertTrue(actual);

    }

    @Test
    void shouldNotBeAbleToIdentifyFourOfKindCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        Hand hand = new Hand();
        FourOfKind fourOfKind = new FourOfKind();
        String userInput = "AH,2D,3S,2C,2H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        hand.start();
        List<Card> cards = hand.getUserHand();
        //assert
        assertFalse(fourOfKind.isFourOfKind(cards));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        Hand hand = new Hand();
        FourOfKind fourOfKind = new FourOfKind();
        String userInput = "AH,2H,2D,2C,2S";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        hand.start();
        List<Card> cards = hand.getUserHand();
        //assert
        assertTrue(fourOfKind.isFourOfKind(cards));
    }

    @Test
    void shouldBeAbleToIdentifyFourOfKindCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        Hand hand = new Hand();
        FourOfKind fourOfKind = new FourOfKind();
        String userInput = "3H,AH,3S,3C,3D";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        hand.start();
        List<Card> cards = hand.getUserHand();
        //assert
        assertTrue(fourOfKind.isFourOfKind(cards));
    }
}
