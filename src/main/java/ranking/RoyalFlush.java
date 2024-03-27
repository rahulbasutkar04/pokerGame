package ranking;

import domain.Card;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;

import java.util.List;

public class RoyalFlush {
    public boolean checkRankingFor(List<Card> cards) throws EmptyCardException, InvalidNumberOfCardException {
     if(cards.isEmpty()) throw  new EmptyCardException("Card should not be empty");
        if (cards.size() != 5) throw new InvalidNumberOfCardException("Five cards are required, got: " + cards.size());

        return false;
    }

    //TODO: Logic to Recognize the Royal Flush
}
