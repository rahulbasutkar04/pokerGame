package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.StraightFlush;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.Suit;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightFlushTest {

    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsStraightFlush() {
        //arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.NINE, Suit.HEARTS));
        //act
        boolean actual = straightFlush.isStraightFlushCheck(cards);
        //assert
        assertTrue(actual);

    }

    @Test
    void shouldNotBeAbleToIdentifyStraightFlushCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        StraightFlush straightFlush = new StraightFlush();
        String userInput = "AH,2D,3S,2C,2H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        //assert
        assertFalse(straightFlush.isStraightFlushCheck(cardList));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        PlayGame playGame = new PlayGame();
        StraightFlush straightFlush = new StraightFlush();
        String userInput = "3H,4H,5H,6H,7H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        //assert
        assertTrue(straightFlush.isStraightFlushCheck(cardList));
    }

}
