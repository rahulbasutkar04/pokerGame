import com.amaap.pokergame.domain.exception.*;
import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Hand;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {
    @Test
    void shouldBeAbleToAssignDeckOfCardToThePlayersToPlayGame() throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {
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
    void shouldBeAbleToThrowExceptionIfMoreThanOneDeckIsAskedByPlayer() {
        // arrange
        int DeckCount = 4;
        PokerManager pokerManager = new PokerManager(DeckCount);

        // act & assert
        assertThrows(InvalidNumberOfDeckException.class, () -> {
            pokerManager.assignDeckToPlayer(2);

        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfZeroNumberOrLessThanOneIsExpectedByPlayer() {
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

        // act & assert
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

    @Test
    void shouldBeAbleToGetTheHandRankWhenCardIsGivenAndGameStarts() throws DeckOutOfAvailabilityException, InvalidNumberOfDeckException, cardAlreadyExistException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException {
        // arrange
        PokerManager pokerManager = new PokerManager(1);
        ByteArrayInputStream in = new ByteArrayInputStream("AH,KH,QH,JH,TH".getBytes());
        System.setIn(in);

        // act
        pokerManager.startGame();
        Hand hand = pokerManager.getPlayGame();
        List<Card> userHand = hand.getUserHand();
        String handRank = pokerManager.getHandRank(userHand);

        // assert
        assertEquals("Royal Flush", handRank);
    }

}

