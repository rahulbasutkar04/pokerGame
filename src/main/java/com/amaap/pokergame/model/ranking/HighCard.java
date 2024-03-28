package com.amaap.pokergame.model.ranking;

import com.amaap.pokergame.model.domain.Card;

import java.util.List;

public class HighCard {
    public boolean isHighCard(List<Card> cards) {
        Card highestCard = cards.get(0); // Initialize with the first card
        for (int i = 1; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            if (currentCard.getRank().compareTo(highestCard.getRank()) > 0) {
                highestCard = currentCard;
            }
        }

        return true;
    }
}
