package rankingtests;

import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import enump.*;
import domain.*;
import ranking.StraightFlush;

import static org.junit.jupiter.api.Assertions.*;


public class StraightFlushTest {

    @Test
    void shouldAbleToCheckIfUserHasTheFiveCardsOrNot() throws EmptyCardException, InvalidNumberOfCardException {
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        // Adding cards to the list
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));

        // Now, you have a list of five cards
       boolean expected= straightFlush.checkRankingFor(cards);

        assertTrue(expected);
    }

    @Test
    void shouldAbleToReturnFalseIfItISNotStraightFlush() throws EmptyCardException, InvalidNumberOfCardException {
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
         boolean expected=straightFlush.checkRankingFor(cards);

        assertFalse(expected);

    }

    @Test
    void shouldAbleToThrowExceptionIfUserHasNoCards()
    {
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        assertThrows(EmptyCardException.class,()->{
            straightFlush.checkRankingFor(cards);
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfLessThanFiveCardFound()
    {
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));

        assertThrows(InvalidNumberOfCardException.class,()->{
            straightFlush.checkRankingFor(cards);
        });

    }
    @Test
    void shouldAbleToThrowExceptionIfMoreThanFiveCardFound()
    {
        StraightFlush straightFlush = new StraightFlush();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.DIAMONDS));

        assertThrows(InvalidNumberOfCardException.class,()->{
            straightFlush.checkRankingFor(cards);
        });

    }

}
