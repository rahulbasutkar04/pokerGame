package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.StraightFlushCheck;

import java.util.Comparator;
import java.util.List;

public class Straight implements StraightFlushCheck {

    @Override
    public boolean isStraightFlushCheck(List<Card> cards) {
        cards.sort(Comparator.comparing(card -> card.getRank()));
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getRank().ordinal() - cards.get(i).getRank().ordinal() != 1) {
                return false;
            }
        }
        return true;
    }
}
