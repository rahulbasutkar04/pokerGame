package com.amaap.pokergametest.domain;

import com.amaap.pokergame.cardAlreadyExistException;
import com.amaap.pokergame.domain.PlayGame;
import com.amaap.pokergame.exception.EmptyCardException;
import com.amaap.pokergame.exception.InvalidCardTypeException;
import com.amaap.pokergame.exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayGameTest {
    @Test
    void shouldBeAbleToTakeFiveCardsAsInputFromTheUser() throws InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        // arrange
        String userInput = "AH, 2D, 3S, 4C, KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        boolean result = PlayGame.start();
        System.setIn(System.in);

        // assert
        assertTrue(result);

    }


    @Test
    void shouldABleToThrowExceptionIfMoreThanFiveCardsAreGiven() {
        //arrange
        String userInput = "AH, 2D, 3S, 4C, KH,JD";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            PlayGame.start();
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfLessThanThreeCardsAreGiven() {
        //arrange
        String userInput = "AH, 2D, 3S";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            PlayGame.start();
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfInputISEmpty() {
        //arrange
        String userInput = " ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        System.setIn(System.in);

        // act & assert
        assertThrows(EmptyCardException.class, () -> {
            PlayGame.start();
        });
    }


    @Test
    void shouldBeAbleToThrowExceptionIfPlaceOfRankAndSuitsAreInterchanged() {
        //arrange
        String userInput = "HA, 2D, 3S, 4C, KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        System.setIn(System.in);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            PlayGame.start();
        });
    }

    @Test
    void shouldBeABleToThrowExceptionIfOtherThanCardIsGivenInput() {

        //arrange
        String userInput = "HA, 2D, 3S, 4C, KP";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            PlayGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfOtherThanCardIsGivenAsInput() {
        //arrange
        String userInput = "12, 48, 48, 34, 56";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            PlayGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfInvalidInoutFormatIsGiven() {
        //arrange
        String userInput = "1234 ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            PlayGame.start();
        });

    }


    @Test
    void shouldBeAbleToThrowExceptionIfSpacesAreGivenInput() {
        //arrange
        String userInput = " ,  , , , ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            PlayGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowInvalidCardTypeExceptionIfCompleteCardIsNotGiven() {
        //arrange
        String userInput = " A, H , J, T,4 ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            PlayGame.start();
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfDoubleCardISFound() throws cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {

        // arrange
        String userInput = "AH, AH, 3S, 4C, KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(cardAlreadyExistException.class, () -> {
            PlayGame.start();
        });

    }


}