package rankingtests;

import domain.Card;
import enump.Rank;
import enump.Suit;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;
import ranking.Flush;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlushTest {

    @Test
    void shouldBeAbleToCheckIfUserHasTheFiveCardsOrNot() throws InvalidNumberOfCardException, EmptyCardException {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // Act
        flush.checkRankingFor(cards);
        //Assert
        assertEquals(5, cards.size());
    }

    @Test
    void shouldBeAbleToIdentifyFlush() throws EmptyCardException, InvalidNumberOfCardException {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        //Act & Assert
        assertTrue(flush.checkRankingFor(cards), "Expected flush");
    }

    @Test
    void shouldNotIdentifyFlushIfDifferentSuits() throws EmptyCardException, InvalidNumberOfCardException {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        //Act & Assert
        assertFalse(flush.checkRankingFor(cards), "Expected no flush");
    }

    @Test
    void shouldBeABleToThrowExceptionForEmptyCardList() {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
       // Act & Assert
        assertThrows(EmptyCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldBeAbleThrowExceptionForLessThanFiveCards() {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        //Act & Assert
        assertThrows(InvalidNumberOfCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldThrowExceptionForMoreThanFiveCards() {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        //Act & Assert
        assertThrows(InvalidNumberOfCardException.class, () -> flush.checkRankingFor(cards));
    }


}
