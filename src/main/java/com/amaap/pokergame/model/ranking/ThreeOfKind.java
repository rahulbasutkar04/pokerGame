package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.util.Rank;
import com.amaap.pokergame.model.util.RankCount;

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
