package com.amaap.pokergame.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("T"), JACK("J"), QUEEN("Q"), KING("K");

    private final String keyword;
    private static final Map<String, Rank> keywordMap = new HashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            keywordMap.put(rank.keyword, rank);
        }
    }
    Rank(String keyword) {
        this.keyword = keyword;
    }
    public static Rank fromKeyword(String keyword) {
        return keywordMap.get(keyword.toUpperCase());
    }
    public String getName() {
        switch (this) {
            case ACE:
                return "ACE";
            case TWO:
                return "TWO";
            case THREE:
                return "THREE";
            case FOUR:
                return "FOUR";
            case FIVE:
                return "FIVE";
            case SIX:
                return "SIX";
            case SEVEN:
                return "SEVEN";
            case EIGHT:
                return "EIGHT";
            case NINE:
                return "NINE";
            case TEN:
                return "TEN";
            case JACK:
                return "JACK";
            case QUEEN:
                return "QUEEN";
            case KING:
                return "KING";
            default:
                throw new IllegalArgumentException("Unknown rank: " + this);
        }
    }
}
