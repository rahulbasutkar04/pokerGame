package com.amaap.pokergame.domain.ranking;

import com.amaap.pokergame.domain.model.Card;

import java.util.List;

public class HighCard {
    public boolean isHighCard(List<Card> cards) {
        Card highestCard = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            if (currentCard.getRank().compareTo(highestCard.getRank()) > 0) {
                highestCard = currentCard;
            }
        }

        return true;
    }

    public Card getHighestCard(List<Card> cardList) {
        Card highestCard = cardList.get(0);
        for (int i = 1; i < cardList.size(); i++) {
            Card currentCard = cardList.get(i);
            if (currentCard.getRank().compareTo(highestCard.getRank()) > 0) {
                highestCard = currentCard;
            }
        }
        return highestCard;
    }

}
