import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Hand;
import com.amaap.pokergame.domain.exception.*;

import java.util.List;

public class PokerManager {
    private int deck;
    private Hand hand;

    public PokerManager(int deck) {
        this.deck = deck;
    }

    public int getDeck() {
        return deck;
    }

    public boolean assignDeckToPlayer(int numberOfDeck) throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {
        if (numberOfDeck <= 0) throw new InvalidNumberOfDeckException("zero or less than this deck can not be allocated.");
        if (numberOfDeck > 1) throw new InvalidNumberOfDeckException("More than one deck cannot be allocated.");
        if (deck == 0) {
            throw new DeckOutOfAvailabilityException();
        }
        deck--;
        return true;
    }

    public boolean startGame() throws DeckOutOfAvailabilityException, InvalidNumberOfDeckException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        hand = new Hand();
        if (assignDeckToPlayer(1)) return hand.start();
        return false;
    }

    public String getHandRank(List<Card> card) {
        if (hand == null) {
            throw new IllegalStateException("The game has not started yet... Call startGame() first.");
        }
        return hand.getHandRankFor(card);
    }

    public Hand getPlayGame() {
        return hand;
    }
}
