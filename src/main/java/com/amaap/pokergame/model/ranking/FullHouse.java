package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.RankCount;

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