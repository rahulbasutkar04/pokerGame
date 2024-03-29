package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Rank;
import com.amaap.pokergame.domain.model.RankCount;

import java.util.List;
import java.util.Map;

public class FourOfKind {

    public static boolean isFourOfKind(List<Card> cards) {
        RankCount rankCounter = new RankCount();
        Map<Rank, Integer> rankCount = rankCounter.rankCount(cards);
        return rankCount.containsValue(4);
    }

}

