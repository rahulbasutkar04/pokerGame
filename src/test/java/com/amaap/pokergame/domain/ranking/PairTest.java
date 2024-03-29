package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.builder.CardBuilder;
import com.amaap.pokergame.domain.exception.EmptyCardException;
import com.amaap.pokergame.domain.exception.InvalidCardTypeException;
import com.amaap.pokergame.domain.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.domain.exception.cardAlreadyExistException;
import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.PlayGame;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PairTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsPair() {
        // arrange
        Pair pair = new Pair();
        List<Card> cards = cardBuilder.getCardFoPair();

        //act
        boolean actual = pair.isPairCard(cards);

        //assert
        assertTrue(actual);
    }

    @Test
    void shouldNotBeAbleToIdentifyPairCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        Pair pair = new Pair();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        // assert
        assertFalse(pair.isPairCard(cards));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        Pair pair = new Pair();
        String userInput = "AH,2D,3S,4C,4H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        playGame.start();
        List<Card> cards = playGame.getUserHand();

        // assert
        assertTrue(pair.isPairCard(cards));
    }

    @Test
    void shouldBeAbleToIdentifyPairCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        Pair pair = new Pair();
        String userInput = "AH,2D,4S,3C,4C";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        playGame.start();
        List<Card> cards = playGame.getUserHand();

        // assert
        assertTrue(pair.isPairCard(cards));
    }
}
