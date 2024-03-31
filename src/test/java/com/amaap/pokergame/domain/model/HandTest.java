package com.amaap.pokergame.domain.model;

import com.amaap.pokergame.domain.exception.EmptyCardException;
import com.amaap.pokergame.domain.exception.InvalidCardTypeException;
import com.amaap.pokergame.domain.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.domain.exception.cardAlreadyExistException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandTest {
    @Test
    void shouldBeAbleToTakeFiveCardsAsInputFromTheUser() throws InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        // arrange
        Hand hand = new Hand();
        String userInput = "AH,2D,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        boolean result = hand.start();
        System.setIn(System.in);
        System.out.println(hand.getUserHand());

        // assert
        assertTrue(result);
    }

    @Test
    void shouldABleToThrowExceptionIfMoreThanFiveCardsAreGiven() {
        // arrange
        Hand hand = new Hand();
        String userInput = "AH,2D,3S,4C,KH,JD";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            hand.start();
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfLessThanThreeCardsAreGiven() {
        // arrange
        Hand hand = new Hand();
        String userInput = "AH,2D,3S";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            hand.start();
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfInputISEmpty() {
        // arrange
        Hand hand = new Hand();
        String userInput = " ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        System.setIn(System.in);

        // act & assert
        assertThrows(EmptyCardException.class, () -> {
            hand.start();
        });
    }


    @Test
    void shouldBeAbleToThrowExceptionIfPlaceOfRankAndSuitsAreInterchanged() {
        // arrange
        Hand hand = new Hand();
        String userInput = "HA,2D,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        System.setIn(System.in);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            hand.start();
        });
    }

    @Test
    void shouldBeABleToThrowExceptionIfOtherThanCardIsGivenInput() {

        // arrange
        Hand hand = new Hand();
        String userInput = "HA,2D,3S,4C,KP";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            hand.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfOtherThanCardIsGivenAsInput() {
        // arrange
        Hand hand = new Hand();
        String userInput = "12,48,48,34,56";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            hand.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfInvalidInoutFormatIsGiven() {
        // arrange
        Hand hand = new Hand();
        String userInput = "1234";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            hand.start();
        });

    }


    @Test
    void shouldBeAbleToThrowExceptionIfSpacesAreGivenInput() {
        // arrange
        Hand hand = new Hand();
        String userInput = " ,  , , , ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            hand.start();
        });

    }

    @Test
    void shouldBeAbleToThrowInvalidCardTypeExceptionIfCompleteCardIsNotGiven() {
        // arrange
        Hand hand = new Hand();
        String userInput = " A,H ,J,T,4";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            hand.start();
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfDoubleCardISFound() {

        // arrange
        Hand hand = new Hand();
        String userInput = "AH,AH,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(cardAlreadyExistException.class, () -> {
            hand.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfSpacesAreGivenAfterEachCard() {
        // arrange
        Hand hand = new Hand();
        String userInput = "AH, AH, 3S, 4C, KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(cardAlreadyExistException.class, () -> {
            hand.start();
        });

    }


}