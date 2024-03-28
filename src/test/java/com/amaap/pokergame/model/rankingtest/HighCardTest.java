package com.amaap.pokergame.model.rankingtest;

import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.domain.Rank;
import com.amaap.pokergame.model.domain.Suit;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.ranking.HighCard;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardTest {

    @Test
    void shouldBeAbleIdentifyTheHighCardCategoryWhenListOfFiveCardIsPassed()
    {
        // arrange
        HighCard highCard=new HighCard();
        List<Card> cards=new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // act
        boolean actual=highCard.isHighCard(cards);
        // assert

        assertTrue(actual);

    }

    @Test
    void shouldBeAbleToRecognizeCardRankingIfActualInputIsGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        HighCard highCard = new HighCard();
        String userInput = "AH,2D,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(highCard.isHighCard(cardList));
    }

    @Test
    void shouldBeAbleToRecognizeHighCardIfOnlyHighRankedCardsAreGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        HighCard highCard = new HighCard();
        String userInput = "AH,KD,QS,JC,QH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(highCard.isHighCard(cardList));

    }

    @Test
    void shouldBeAbleToRecognizeLowHighCardIfOnlyLowerRankedCardsAreGiven() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PlayGame playGame = new PlayGame();
        HighCard highCard = new HighCard();
        String userInput = "TH,2D,3S,5C,9H";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        // act
        playGame.start();
        Set<Card> cards = playGame.getUserHand();
        List<Card> cardList = new ArrayList<>(cards);
        // assert
        assertTrue(highCard.isHighCard(cardList));
    }

}
