import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.*;

import java.util.List;

public class PokerManager {
    private int deck;
    private PlayGame playGame;

    public PokerManager(int deck) {
        this.deck = deck;
    }

    public int getDeck() {
        return deck;
    }

    public boolean assignDeckToPlayer(int numberOfDeck) throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {
        if (numberOfDeck <= 0) throw new InvalidNumberOfDeckException("zero or less than this can not be allocated.");
        if (numberOfDeck > 1) throw new InvalidNumberOfDeckException("More than one deck cannot be allocated.");
        if (deck == 0) {
            throw new DeckOutOfAvailabilityException();
        }
        deck--;
        return true;
    }

    public boolean startGame() throws DeckOutOfAvailabilityException, InvalidNumberOfDeckException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        playGame = new PlayGame();
        if (assignDeckToPlayer(1)) return playGame.start();
        return false;
    }

    public String getHandRank(List<Card> card) {
        if (playGame == null) {
            throw new IllegalStateException("The game has not started yet... Call startGame() first.");
        }
        return playGame.getHandRankFor(card);
    }

    public PlayGame getPlayGame() {
        return playGame;
    }
}
