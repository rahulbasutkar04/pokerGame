package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.util.StraightFlushCheck;

import java.util.List;

public class StraightFlush implements StraightFlushCheck {

    private StraightFlushCheck straightChecker = new Straight();
    private StraightFlushCheck flushChecker = new Flush();

    @Override
    public boolean isStraightFlushCheck(List<Card> cards) {
        return straightChecker.isStraightFlushCheck(cards) && flushChecker.isStraightFlushCheck(cards);
    }
}
