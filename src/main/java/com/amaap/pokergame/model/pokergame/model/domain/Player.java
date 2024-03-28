package com.amaap.pokergame.model.pokergame.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void selectCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }
}
