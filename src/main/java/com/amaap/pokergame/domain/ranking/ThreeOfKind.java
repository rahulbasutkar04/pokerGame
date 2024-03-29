package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.model.Card;
import com.amaap.pokergame.domain.model.Rank;
import com.amaap.pokergame.domain.model.RankCount;

import java.util.List;
import java.util.Map;

public class ThreeOfKind {
    public boolean isThreeOfKind(List<Card> cards) {

        RankCount rc = new RankCount();

        return hasThreeOfAKind(rc.rankCount(cards));
    }

    private static boolean hasThreeOfAKind(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(3);
    }
}
