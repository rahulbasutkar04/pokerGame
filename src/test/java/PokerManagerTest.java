import domain.PokerManager;
import exception.DeckOutOfAvailabilityException;
import exception.InvalidNumberOfDeckException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {


    @Test
    void shouldAbleToAssignDeckOfCardToThePlayersToPlayGame() throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {

        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);


        pokerManager.assignDeckToPlayer(1);


        int actual = pokerManager.getDeck();
        assertEquals(3, actual);

    }


    @Test
    void shouldAbleToThrowExceptionIfMoreThanOneDeckIsAskedByPlayer() {
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
        assertThrows(InvalidNumberOfDeckException.class, () -> {
            pokerManager.assignDeckToPlayer(2);

        });
    }

    @Test
    void shouldAbleToThrowExceptionIfZeroNumberOrLessThanOneIsExpectedByPlayer() {
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
        assertThrows(InvalidNumberOfDeckException.class, () -> {
            pokerManager.assignDeckToPlayer(-1);

        });
    }


    @Test
    void shouldAbleToThrowExceptionIfNoDeckISAvailableToAllocate() {
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
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
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);
        pokerManager.assignDeckToPlayer(1);

        boolean isCardAssignedToUSer = pokerManager.startGame("Rahul");

        assertTrue(isCardAssignedToUSer);

    }
}
