package rankingtests;

import domain.Card;
import enump.Rank;
import enump.Suit;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;
import org.junit.jupiter.api.Test;
import ranking.Flush;
import ranking.RoyalFlush;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoyalFlushTest{



    @Test
    void shouldAbleToCheckIfUserHasTheFiveCardsOrNot() throws InvalidNumberOfCardException, EmptyCardException {
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
}
