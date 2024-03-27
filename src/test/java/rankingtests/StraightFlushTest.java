package rankingtests;

import domain.Card;
import enump.Rank;
import enump.Suit;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;
import ranking.Flush;
import ranking.StraightFlush;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StraightFlushTest {

    @Test
    void shouldAbleToCheckIfUserHasTheFiveCardsOrNot() throws EmptyCardException, InvalidNumberOfCardException {
        //Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        //Act & Assert
        straightFlush.checkRankingFor(cards);

        assertEquals(5, cards.size());
    }

    @Test
    void shouldAbleToReturnFalseIfItISNotStraightFlush() throws EmptyCardException, InvalidNumberOfCardException {
        //Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        //Act
        boolean expected = straightFlush.checkRankingFor(cards);
        //Assert
        assertFalse(expected);

    }

    @Test
    void shouldAbleToThrowExceptionIfUserHasNoCards() {
        //Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();
       //Act & Assert
        assertThrows(EmptyCardException.class, () -> {
            straightFlush.checkRankingFor(cards);
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfLessThanFiveCardFound() {

        //Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
       //Act & Assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            straightFlush.checkRankingFor(cards);
        });

    }

    @Test
    void shouldAbleToThrowExceptionIfMoreThanFiveCardFound() {

        //Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        //Act & Assert
        assertThrows(InvalidNumberOfCardException.class, () -> {
            straightFlush.checkRankingFor(cards);
        });

    }

    @Test
    void shouldBeAbleToIdentifyFlush() throws EmptyCardException, InvalidNumberOfCardException {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
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
    void shouldThrowExceptionForEmptyCardList() {
        //Arrange
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        //Act & Assert
        assertThrows(EmptyCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldThrowExceptionForLessThanFiveCards() {
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
