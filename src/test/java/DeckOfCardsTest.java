import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Test
    void shouldAbleToInitialiseDeckWithAllCards() {
        //Arrange
        DeckOfCards deck = new DeckOfCards();
        //Act
        List<Card> cards = deck.getCards();

        //Assert
        assertEquals(52, cards.size());
    }


    @Test
    void shouldAbleToAssignTheFiveCardsToUser() {
        // Arrange
        DeckOfCards deck = new DeckOfCards();
        Player user = new Player();

        // Act
        deck.assignTheFiveCardsToUser(user);
        List<Card> userHand = user.getHand();

        // Assert
        assertEquals(5, userHand.size(), "User should have 5 cards in hand only");
        assertTrue(deck.getCards().size() >= 47, "Deck should have at least 47 cards remaining after assignment of card to player");
    }

    @Test
    void shouldAbleToShuffleTheCards() {
        DeckOfCards deck1 = new DeckOfCards();
        DeckOfCards deck2 = new DeckOfCards();

        // Shuffle both decks
        deck1.shuffle();
        deck2.shuffle();

        // Compare the order of cards in both decks
        assertNotEquals(deck1.getCards(), deck2.getCards(), "Decks should be shuffled differently");
    }


}