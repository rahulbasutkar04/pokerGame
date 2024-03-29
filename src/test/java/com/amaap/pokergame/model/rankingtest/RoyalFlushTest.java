package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.RoyalFlush;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.Suit;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoyalFlushTest {

    @Test
    void shouldBeAbleToIdentifyRoyalFlushCardRank() {
        //arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.JACK, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        //act
        boolean actual = royalFlush.isStraightFlushCheck(cards);
        //assert
        assertTrue(actual);
    }

    @Test
    void shouldNotBeAbleToIdentifyRoyalCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        RoyalFlush royalFlush = new RoyalFlush();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();;
        //assert
        assertFalse(royalFlush.isStraightFlushCheck(cards));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        RoyalFlush royalFlush = new RoyalFlush();
        String userInput = "AH,KH,QH,JH,TH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();;
        //assert
        assertTrue(royalFlush.isStraightFlushCheck(cards));
    }

    @Test
    void shouldBeAbleToIdentifyFlushCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        RoyalFlush royalFlush = new RoyalFlush();
        String userInput = "TH,AH,JH,QH,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();;
        //assert
        assertTrue(royalFlush.isStraightFlushCheck(cards));
    }
}
