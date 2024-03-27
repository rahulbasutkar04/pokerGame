package rankingtests;

import domain.Card;
import enump.Rank;
import enump.Suit;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;
import ranking.RoyalFlush;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoyalFlushTest {


    @Test
    void shouldAbleToCheckIfUserHasTheFiveCardsOrNot() throws EmptyCardException, InvalidNumberOfCardException {
        //Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // Act
        royalFlush.checkRankingFor(cards);
        //Assert
        assertEquals(5, cards.size());
    }

    @Test
    void shouldAbleToThrowExceptionIfEmptyListOfCardIsGiven() {
        //Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        assertThrows(EmptyCardException.class, () -> {
            royalFlush.checkRankingFor(cards);
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfMorThanFiveCardIsGiven() {
        //Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        //Act & Assert
        assertThrows(InvalidNumberOfCardException.class, () -> royalFlush.checkRankingFor(cards));
    }

    @Test
    void shouldBeAbleThrowExceptionForLessThanFiveCards() {
        //Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        //Act & Assert
        assertThrows(InvalidNumberOfCardException.class, () -> royalFlush.checkRankingFor(cards));
    }


    @Test
    void shouldBeAbleToIdentifyRoyalFlush() throws EmptyCardException, InvalidNumberOfCardException {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.JACK, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));

        // Act & Assert
        assertTrue(royalFlush.checkRankingFor(cards), "Expected Royal Flush");
    }


}
