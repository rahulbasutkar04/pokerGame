package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Rank;
import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.util.RankCount;

import java.util.HashMap;
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
