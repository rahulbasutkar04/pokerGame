package com.amaap.pokergame.model.pokergame.model.ranking;

import com.amaap.pokergame.model.pokergame.model.domain.Card;
import com.amaap.pokergame.model.pokergame.model.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair {
    public boolean isPairCard(List<Card> cards) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return hasOnePair(rankCount);

    }

    private static boolean hasOnePair(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(2);
    }
}
