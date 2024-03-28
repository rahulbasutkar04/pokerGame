package com.amaap.pokergametest.modeltest.domaintest;

import com.amaap.pokergame.model.exception.cardAlreadyExistException;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayGameTest {
    @Test
    void shouldBeAbleToTakeFiveCardsAsInputFromTheUser() throws InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        // arrange
        PlayGame playGame=new PlayGame();
        String userInput = "AH,2D, 3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act
        boolean result = playGame.start();
        System.setIn(System.in);
        System.out.println(playGame.getUserHand());

        // assert
        assertTrue(result);

    }


    @Test
    void shouldABleToThrowExceptionIfMoreThanFiveCardsAreGiven() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = "AH,2D,3S,4C,KH,JD";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            playGame.start();
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfLessThanThreeCardsAreGiven() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = "AH,2D,3S";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            playGame.start();
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfInputISEmpty() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = " ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        System.setIn(System.in);

        // act & assert
        assertThrows(EmptyCardException.class, () -> {
            playGame.start();
        });
    }


    @Test
    void shouldBeAbleToThrowExceptionIfPlaceOfRankAndSuitsAreInterchanged() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = "HA,2D,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        System.setIn(System.in);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            playGame.start();
        });
    }

    @Test
    void shouldBeABleToThrowExceptionIfOtherThanCardIsGivenInput() {

        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = "HA,2D,3S,4C,KP";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            playGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfOtherThanCardIsGivenAsInput() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = "12,48,48,34,56";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            playGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfInvalidInoutFormatIsGiven() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = "1234";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            playGame.start();
        });

    }


    @Test
    void shouldBeAbleToThrowExceptionIfSpacesAreGivenInput() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = " ,  , , , ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            playGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowInvalidCardTypeExceptionIfCompleteCardIsNotGiven() {
        //arrange
        PlayGame playGame=new PlayGame();
        String userInput = " A,H ,J,T,4";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            playGame.start();
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfDoubleCardISFound(){

        // arrange
        PlayGame playGame=new PlayGame();
        String userInput = "AH,AH,3S,4C,KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(cardAlreadyExistException.class, () -> {
            playGame.start();
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfSpacesAreGivenAfterEachCard()
    {
        // arrange
        PlayGame playGame=new PlayGame();
        String userInput = "AH, AH, 3S, 4C, KH";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // act & assert
        assertThrows(cardAlreadyExistException.class, () -> {
            playGame.start();
        });

    }


}