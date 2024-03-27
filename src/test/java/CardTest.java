import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {


    @Test
    void shouldAbleToCreateCardWithRankAndSuit(){
        // Arrange
        Rank expectedRank = Rank.ACE;
        Suit expectedSuit = Suit.HEARTS;

        // Act
        Card card = new Card(expectedRank, expectedSuit);

        // Assert
        assertNotNull(card, "Card should not be null");

    }

    @Test
    void shouldAbleToGetRankAfterCreationOfCard()
    {

        // Arrange
        Rank expectedRank = Rank.JACK;
        Suit suit = Suit.CLUBS;

        // Act
        Card card = new Card(expectedRank, suit);
        Rank actualRank = card.getRank();

        // Assert
        assertEquals(expectedRank, actualRank, "Rank should be JACK");

    }

    @Test
    void shouldAbleToGetSuitAfterCreationOfCard()
    {

        // Arrange
        Rank rank = Rank.JACK;
        Suit ExpectedSuit = Suit.CLUBS;

        // Act
        Card card = new Card(rank,ExpectedSuit);
        Suit actualSuit = card.getSuit();

        // Assert
        assertEquals( ExpectedSuit, actualSuit, "Suit  should be Clubs");

    }

}