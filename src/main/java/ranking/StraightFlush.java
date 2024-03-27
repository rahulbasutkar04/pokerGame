package ranking;

import domain.Card;
import enump.Rank;
import enump.Suit;
import exception.EmptyCardException;
import exception.InvalidNumberOfCardException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StraightFlush {
    public boolean checkRankingFor(List<Card> cards) throws EmptyCardException, InvalidNumberOfCardException {
        if(cards.isEmpty()) throw  new EmptyCardException("don't have any card , Bring Five cards..");
        if(cards.size()<5 || cards.size()>=6) throw  new InvalidNumberOfCardException("Card Number is less" +cards.size());

        Map<Rank, Integer> rankCount = countRanks(cards);
        Map<Suit, Integer> suitCount = countSuits(cards);
        return hasStraightFlush(cards, rankCount, suitCount);
    }

    private Map<Rank, Integer> countRanks(List<Card> cards) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    private Map<Suit, Integer> countSuits(List<Card> cards) {
        Map<Suit, Integer> suitCount = new HashMap<>();
        for (Card card : cards) {
            Suit suit = card.getSuit();
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        return suitCount;
    }

    private boolean hasStraightFlush(List<Card> cards, Map<Rank, Integer> rankCount, Map<Suit, Integer> suitCount) {
        return hasStraight(cards, rankCount) && hasFlush(suitCount);
    }

    private boolean hasStraight(List<Card> cards, Map<Rank, Integer> rankCount) {
        cards.sort(Comparator.comparing(card -> card.getRank()));

        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getRank().ordinal() - cards.get(i).getRank().ordinal() != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasFlush(Map<Suit, Integer> suitCount) {
        return suitCount.containsValue(5);
    }
}
