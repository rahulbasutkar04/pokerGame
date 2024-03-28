package com.amaap.pokergame.domain;

import com.amaap.pokergame.model.Rank;
import com.amaap.pokergame.model.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> cards;

    public DeckOfCards() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }


    public void assignTheFiveCardsToUser(Player user) {
        if (cards.size() < 5) {
            throw new IllegalStateException("Insufficient cards in the deck");
        }

        for (int i = 0; i < 5; i++) {
            Card dealtCard = cards.remove(0); // Remove the top card from the deck
            user.selectCard(dealtCard); // Add the card to the user's hand
        }
    }


}
