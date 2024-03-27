package ranking;

import domain.Card;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;

import java.util.List;

public class RoyalFlush {
    private final StraightFlush straightFlush;

    public RoyalFlush() {
        this.straightFlush = new StraightFlush();
    }

    public boolean checkRankingFor(List<Card> cards) throws EmptyCardException, InvalidNumberOfCardException {
        if (cards.isEmpty()) throw new EmptyCardException("Card should not be empty");
        if (cards.size() != 5) throw new InvalidNumberOfCardException("Five cards are required, got: " + cards.size());

        return straightFlush.checkRankingFor(cards) && containsAce(cards);
    }

    private boolean containsAce(List<Card> cards) {
        boolean tenFound = false, jackFound = false, queenFound = false, kingFound = false, aceFound = false;
        for (Card card : cards) {
            switch (card.getRank()) {
                case TEN:
                    tenFound = true;
                    break;
                case JACK:
                    jackFound = true;
                    break;
                case QUEEN:
                    queenFound = true;
                    break;
                case KING:
                    kingFound = true;
                    break;
                case ACE:
                    aceFound = true;
                    break;
            }
        }
        return tenFound && jackFound && queenFound && kingFound && aceFound;
    }
}
