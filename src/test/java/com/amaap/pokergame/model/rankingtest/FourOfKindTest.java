package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.ranking.FourOfKind;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.Suit;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourOfKindTest {

    @Test
    void shouldBeAbleToIdentifyTheRankOfHandCardIsFourOfKind() {
        //arrange
        FourOfKind fourOfKind = new FourOfKind();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        //act
        boolean actual = fourOfKind.isFourOfKind(cards);
        //assert
        assertTrue(actual);

    }

    @Test
    void shouldNotBeAbleToIdentifyFourOfKindCardIfItIsNot() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        FourOfKind fourOfKind = new FourOfKind();
        String userInput = "AH,2D,3S,2C,2H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertFalse(fourOfKind.isFourOfKind(cards));
    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        FourOfKind fourOfKind = new FourOfKind();
        String userInput = "AH,2H,2D,2C,2S";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertTrue(fourOfKind.isFourOfKind(cards));
    }

    @Test
    void shouldBeAbleToIdentifyFourOfKindCardIfPresentAtAnyOrder() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        //arrange
        PlayGame playGame = new PlayGame();
        FourOfKind fourOfKind = new FourOfKind();
        String userInput = "3H,AH,3S,3C,3D";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        //act
        playGame.start();
        List<Card> cards = playGame.getUserHand();
        //assert
        assertTrue(fourOfKind.isFourOfKind(cards));
    }
}
