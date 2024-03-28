import com.amaap.pokergame.model.domain.PlayGame;
import com.amaap.pokergame.model.exception.*;

public class PokerManager {

    private int deck;

    public PokerManager(int deck) {
        this.deck = deck;
    }

    public int getDeck() {
        return deck;
    }

    public boolean assignDeckToPlayer(int numberOfDeck) throws InvalidNumberOfDeckException, DeckOutOfAvailabilityException {
        if (numberOfDeck <= 0) throw new InvalidNumberOfDeckException("zero or less than this can not be allocate.");
        if (numberOfDeck > 1) throw new InvalidNumberOfDeckException("More than one deck can not allocate.");
        if(deck==0) {
            throw new DeckOutOfAvailabilityException();
        }
         deck--;
        return  true;
    }


    public boolean startGame() throws DeckOutOfAvailabilityException, InvalidNumberOfDeckException, InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
      PlayGame playGame=new PlayGame();
        if(assignDeckToPlayer(1)) return playGame.start();

        return  false;
    }
}
