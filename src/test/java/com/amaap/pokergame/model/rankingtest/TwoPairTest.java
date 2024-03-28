package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.domain.Rank;
import com.amaap.pokergame.model.domain.Suit;
import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.Pair;
import com.amaap.pokergame.model.ranking.TwoPair;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoPairTest {

    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsTwoPair() {
        // arrange
       TwoPair twoPair = new TwoPair();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        // act
        boolean actual = twoPair.isTwoPairCard(cards);
        // assert
        assertTrue(actual);

    }


    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        TwoPair twoPair=new TwoPair();
        String userInput = "AH,2D,2S,4C,4H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(twoPair.isTwoPairCard(cardList));
    }

    @Test
    void shouldNotBeAbleToIdentifyTwoPairCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        TwoPair twoPair=new TwoPair();
        String userInput = "AH,2D,3S,4C,6H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertFalse(twoPair.isTwoPairCard(cardList));
    }

    @Test
    void shouldBeAbleToIdentifyPairCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        TwoPair twoPair=new TwoPair();
        String userInput = "2H,AD,2S,3C,3H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(twoPair.isTwoPairCard(cardList));
    }

}