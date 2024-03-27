package ranking;

import domain.Card;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;

import java.util.Comparator;
import java.util.List;

public class StraightFlush {
    private final Flush flush;

    public StraightFlush() {
        this.flush = new Flush();
    }

    public boolean checkRankingFor(List<Card> cards) throws EmptyCardException, InvalidNumberOfCardException {
        if (cards.isEmpty()) throw new EmptyCardException("Don't have any card, bring five cards.");
        if (cards.size() != 5) throw new InvalidNumberOfCardException("Five cards are required, got: " + cards.size());

        return hasStraightFlush(cards) && flush.checkRankingFor(cards);
    }

    private boolean hasStraightFlush(List<Card> cards) {
        cards.sort(Comparator.comparing(card -> card.getRank()));

        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getRank().ordinal() - cards.get(i).getRank().ordinal() != 1) {
                return false;
            }
        }
        return true;
    }
}
