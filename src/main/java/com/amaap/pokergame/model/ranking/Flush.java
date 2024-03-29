package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.Suit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flush {
    public boolean isFlushCard(List<Card> cards) {
        Map<Suit, Integer> suitCount = new HashMap<>();
        for (Card card : cards) {
            Suit suit = card.getSuit();
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        return suitCount.containsValue(5);
    }
}
