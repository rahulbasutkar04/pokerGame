import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {


    @Test

    void shouldAbleToAssignDeckOfCardToThePlayersToPlayGame() throws InvalidNumberOfDeckException {

        int DeckCount=4;
        PokerManager pokerManager=new PokerManager(DeckCount);  //Initially poker manager should have  4 decks only


        pokerManager.assignDeckToPlayer(1);  //it should return the total remianing amount of deck card


        int actual=pokerManager.getDeck();
        assertEquals(3,actual);

    }


    @Test
    void shouldAbleToThrowExceptionIfMoreThanOneDeckIsAskedByPlayer()
    {
        int DeckCount=4;
        PokerManager pokerManager=new PokerManager(DeckCount);
        assertThrows(InvalidNumberOfDeckException.class,()->{
            pokerManager.assignDeckToPlayer(2);

        });
    }

    @Test
    void shouldAbleToThrowExceptionIfZeroNumberOrLessThanOneIsExpectedByPlayer()
    {
        int DeckCount=4;
        PokerManager pokerManager=new PokerManager(DeckCount);
        assertThrows(InvalidNumberOfDeckException.class,()->{
            pokerManager.assignDeckToPlayer(-1);

        });
    }
}
