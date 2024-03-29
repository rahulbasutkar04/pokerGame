package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.Rank;
import com.amaap.pokergame.model.domain.Suit;
import com.amaap.pokergame.model.util.StraightFlushCheck;

import java.util.List;

public class RoyalFlush implements StraightFlushCheck {
    @Override
    public boolean isStraightFlushCheck(List<Card> cards) {

        Suit firstSuit = cards.get(0).getSuit();
        boolean sameSuit = cards.stream().allMatch(card -> card.getSuit() == firstSuit);
        if (!sameSuit) {
            return false;
        }
        boolean containsTen = false, containsJack = false, containsQueen = false, containsKing = false, containsAce = false;
        for (Card card : cards) {
            Rank rank = card.getRank();
            switch (rank) {
                case TEN:
                    containsTen = true;
                    break;
                case JACK:
                    containsJack = true;
                    break;
                case QUEEN:
                    containsQueen = true;
                    break;
                case KING:
                    containsKing = true;
                    break;
                case ACE:
                    containsAce = true;
                    break;
            }
        }

        return containsTen && containsJack && containsQueen && containsKing && containsAce;
    }
}
