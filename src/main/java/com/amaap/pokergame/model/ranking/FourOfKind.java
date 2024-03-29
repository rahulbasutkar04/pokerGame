package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.RankCount;

import java.util.List;
import java.util.Map;

public class FourOfKind {

    public static boolean isFourOfKind(List<Card> cards) {
        RankCount rankCounter = new RankCount();
        Map<Rank, Integer> rankCount = rankCounter.rankCount(cards);
        return rankCount.containsValue(4);
    }

}

