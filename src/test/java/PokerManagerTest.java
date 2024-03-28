import com.amaap.pokergame.exception.DeckOutOfAvailabilityException;
import com.amaap.pokergame.exception.InvalidNumberOfDeckException;
import org.junit.jupiter.api.Test;

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
    void shouldAbleToStartTheGameForThePlayer() throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {
        // arrange
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
        pokerManager.assignDeckToPlayer(1);

        // act
        boolean isCardAssignedToUSer = pokerManager.startGame("Rahul");
        // assert
        assertTrue(isCardAssignedToUSer);

    }
}
