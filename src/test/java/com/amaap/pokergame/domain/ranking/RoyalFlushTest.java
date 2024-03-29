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


public class RoyalFlushTest {

    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIdentifyRoyalFlushCardRank() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = cardBuilder.getCardForRoyalFlush();

        // act
        boolean actual = royalFlush.isStraightFlushCheck(cards);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldNotBeAbleToIdentifyRoyalCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        RoyalFlush royalFlush = new RoyalFlush();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act

        playGame.start();
        List<Card> cards = playGame.getUserHand();

        // assert
        assertFalse(royalFlush.isStraightFlushCheck(cards));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        RoyalFlush royalFlush = new RoyalFlush();
        String userInput = "AH,KH,QH,JH,TH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        playGame.start();
        List<Card> cards = playGame.getUserHand();

        // assert
        assertTrue(royalFlush.isStraightFlushCheck(cards));
    }

    @Test
    void shouldBeAbleToIdentifyFlushCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        RoyalFlush royalFlush = new RoyalFlush();
        String userInput = "TH,AH,JH,QH,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        playGame.start();
        List<Card> cards = playGame.getUserHand();

        // assert
        assertTrue(royalFlush.isStraightFlushCheck(cards));
    }
}
