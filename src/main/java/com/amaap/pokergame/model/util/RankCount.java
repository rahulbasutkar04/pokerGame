package com.amaap.pokergame.model.util;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCount {


    public Map<Rank, Integer> rankCount(List<Card> cards)
    {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }
}
