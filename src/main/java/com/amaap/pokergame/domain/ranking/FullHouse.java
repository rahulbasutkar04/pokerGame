package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Rank;
import com.amaap.pokergame.domain.model.RankCount;

import java.util.List;
import java.util.Map;

public class FullHouse {
    public boolean isFullHouse(List<Card> cards) {
        RankCount rc = new RankCount();
        Map<Rank, Integer> rankCount = rc.rankCount(cards);
        return hasFullHouse(rankCount);
    }

    private static boolean hasFullHouse(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(3) && rankCount.containsValue(2);
    }
}
