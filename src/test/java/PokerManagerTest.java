import com.amaap.pokergame.model.exception.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {


    @Test
    void shouldAbleToAssignDeckOfCardToThePlayersToPlayGame() throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {
        // arrange
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);

        // act
        pokerManager.assignDeckToPlayer(1);

        // assert

        int actual = pokerManager.getDeck();
        assertEquals(3, actual);

    }


    @Test
    void shouldAbleToThrowExceptionIfMoreThanOneDeckIsAskedByPlayer() {
        // arrange
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);

        // act & assert
        assertThrows(InvalidNumberOfDeckException.class, () -> {
            pokerManager.assignDeckToPlayer(2);

        });
    }

    @Test
    void shouldAbleToThrowExceptionIfZeroNumberOrLessThanOneIsExpectedByPlayer() {
        // arrange
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
        // act & assert
        assertThrows(InvalidNumberOfDeckException.class, () -> {
            pokerManager.assignDeckToPlayer(-1);
        });
    }


    @Test
    void shouldAbleToThrowExceptionIfNoDeckISAvailableToAllocate() {
        // arrange
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
        //  act & assert
        assertThrows(DeckOutOfAvailabilityException.class, () -> {
            pokerManager.assignDeckToPlayer(1);
            pokerManager.assignDeckToPlayer(1);
            pokerManager.assignDeckToPlayer(1);
            pokerManager.assignDeckToPlayer(1);
            pokerManager.assignDeckToPlayer(1);

        });
    }


    @Test
    void shouldAbleToStartTheGameForThePlayer() throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException, InvalidNumberOfCardException, EmptyCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        // arrange
        int deckCount = 4;
        PokerManager pokerManager = new PokerManager(deckCount);
        pokerManager.assignDeckToPlayer(1);
        ByteArrayInputStream in = new ByteArrayInputStream("AH, 2D, 3S, 4C, KH".getBytes());
        System.setIn(in);
        // act
        boolean isGameStarted = pokerManager.startGame();
        // assert
        assertTrue(isGameStarted);
    }

}

