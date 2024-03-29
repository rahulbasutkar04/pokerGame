package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.model.Rank;
import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.RankCount;

import java.util.List;
import java.util.Map;

public class Pair {
    public boolean isPairCard(List<Card> cards) {
        RankCount rc=new RankCount();
        return hasOnePair(rc.rankCount(cards));

    }
    private static boolean hasOnePair(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(2);
    }
}
