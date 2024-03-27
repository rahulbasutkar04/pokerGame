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
    void shouldAbleToCheckIfUserHasTheFiveCardsOrNot() throws InvalidNumberOfCardException, EmptyCardException {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        // Adding cards to the list
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // Now, you have a list of five cards
        flush.checkRankingFor(cards);

        assertEquals(5, cards.size());
    }

    @Test
    void shouldAbleToIdentifyFlush() throws EmptyCardException, InvalidNumberOfCardException {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        // Add five cards of the same suit
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        assertTrue(flush.checkRankingFor(cards), "Expected flush");
    }

    @Test
    void shouldNotIdentifyFlushIfDifferentSuits() throws EmptyCardException, InvalidNumberOfCardException {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        // Add five cards of different suits
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        assertFalse(flush.checkRankingFor(cards), "Expected no flush");
    }

    @Test
    void shouldThrowExceptionForEmptyCardList() {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        assertThrows(EmptyCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldThrowExceptionForLessThanFiveCards() {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        // Add only four cards
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));

        assertThrows(InvalidNumberOfCardException.class, () -> flush.checkRankingFor(cards));
    }

    @Test
    void shouldThrowExceptionForMoreThanFiveCards() {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();

        // Add six cards
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));

        assertThrows(InvalidNumberOfCardException.class, () -> flush.checkRankingFor(cards));
    }


}
