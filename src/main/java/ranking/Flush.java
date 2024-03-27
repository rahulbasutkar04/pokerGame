package ranking;

import domain.Card;
import enump.Suit;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flush {
    public boolean checkRankingFor(List<Card> cards) throws InvalidNumberOfCardException, EmptyCardException {
        if (cards.isEmpty()) throw new EmptyCardException("Don't have any card, bring five cards.");
        if (cards.size() != 5) throw new InvalidNumberOfCardException("Five cards are required, got: " + cards.size());
        Map<Suit, Integer> suitCount = countSuits(cards);
        return hasFlush(suitCount);
    }

    private Map<Suit, Integer> countSuits(List<Card> cards) {
        Map<Suit, Integer> suitCount = new HashMap<>();
        for (Card card : cards) {
            Suit suit = card.getSuit();
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        return suitCount;
    }

    private boolean hasFlush(Map<Suit, Integer> suitCount) {
        return suitCount.containsValue(5);
    }
}
