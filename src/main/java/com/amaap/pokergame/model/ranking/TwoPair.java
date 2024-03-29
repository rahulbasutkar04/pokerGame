package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.RankCount;

import java.util.List;
import java.util.Map;

public class TwoPair {
    public boolean isTwoPairCard(List<Card> cards) {
        RankCount rc = new RankCount();

        return hasTwoPair(rc.rankCount(cards));
    }

    private static boolean hasTwoPair(Map<Rank, Integer> rankCount) {
        int pairCount = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

}
