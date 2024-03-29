package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.Flush;
import com.amaap.pokergame.model.ranking.FullHouse;
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

public class FullHouseTest {

    @Test
    void shouldBeAbleToIdentifyFullOfCardRank() {
        //arrange
        FullHouse fullHouse = new FullHouse();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
        cards.add(new Card(Rank.SIX, Suit.SPADES));
        cards.add(new Card(Rank.SIX, Suit.DIAMONDS));
        //act
        boolean actual = fullHouse.isFullHouse(cards);
        //assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        FullHouse fullHouse = new FullHouse();
        String userInput = "QH,QD,QC,4H,4C";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertTrue(fullHouse.isFullHouse(cards));
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
    void shouldBeAbleToIdentifyFullHouseIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        FullHouse fullHouse = new FullHouse();
        String userInput = "4D,QD,QC,4H,QH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertTrue(fullHouse.isFullHouse(cards));
    }
}
