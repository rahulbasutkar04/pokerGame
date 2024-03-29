package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.domain.Rank;
import com.amaap.pokergame.model.domain.Suit;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.Flush;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushTest {
    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsFlush() {
        // arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        // act
        boolean actual = flush.isFlushCard(cards);
        // assert

        assertTrue(actual);

    }

    @Test
    void shouldNotBeAbleToIdentifyFlushCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        Flush flush = new Flush();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertFalse(flush.isFlushCard(cardList));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        Flush flush = new Flush();
        String userInput = "AH,2H,3H,4H,5H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(flush.isFlushCard(cardList));
    }

    @Test
    void shouldBeAbleToIdentifyFlushCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        Flush flush = new Flush();
        String userInput = "AH,2H,4H,3H,5H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(flush.isFlushCard(cardList));
    }

}
