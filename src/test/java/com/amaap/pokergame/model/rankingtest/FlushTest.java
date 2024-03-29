package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.Flush;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.StraightFlushCheck;
import com.amaap.pokergame.model.util.Suit;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushTest {
    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsFlush() {
        //arrange
        StraightFlushCheck flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        //act
        boolean actual = flush.isStraightFlushCheck(cards);
        //assert
        assertTrue(actual);

    }

    @Test
    void shouldNotBeAbleToIdentifyFlushCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        StraightFlushCheck flush = new Flush();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertFalse(flush.isStraightFlushCheck(cards));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        StraightFlushCheck flush = new Flush();
        String userInput = "AH,2H,3H,4H,5H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertTrue(flush.isStraightFlushCheck(cards));
    }

    @Test
    void shouldBeAbleToIdentifyFlushCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        StraightFlushCheck flush = new Flush();
        String userInput = "AH,2H,4H,3H,5H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertTrue(flush.isStraightFlushCheck(cards));
    }
}
