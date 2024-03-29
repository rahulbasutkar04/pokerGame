package com.amaap.pokergame.domain.model;

import com.amaap.pokergame.domain.ranking.*;

import java.util.List;

public class HandEvaluator {

    public HandRanking evaluateHand(List<Card> cardList) {

        if (new RoyalFlush().isStraightFlushCheck(cardList)) {
            return HandRanking.ROYAL_FLUSH;
        } else if (new StraightFlush().isStraightFlushCheck(cardList)) {
            return HandRanking.STRAIGHT_FLUSH;
        } else if (FourOfKind.isFourOfKind(cardList)) {
            return HandRanking.FOUR_OF_A_KIND;
        } else if (new FullHouse().isFullHouse(cardList)) {
            return HandRanking.FULL_HOUSE;
        } else if (new Flush().isStraightFlushCheck(cardList)) {
            return HandRanking.FLUSH;
        } else if (new Straight().isStraightFlushCheck(cardList)) {
            return HandRanking.STRAIGHT;
        } else if (new ThreeOfKind().isThreeOfKind(cardList)) {
            return HandRanking.THREE_OF_A_KIND;
        } else if (new TwoPair().isTwoPairCard(cardList)) {
            return HandRanking.TWO_PAIR;
        } else if (new Pair().isPairCard(cardList)) {
            return HandRanking.ONE_PAIR;
        } else {
            return HandRanking.HIGH_CARD;
        }
    }
}
