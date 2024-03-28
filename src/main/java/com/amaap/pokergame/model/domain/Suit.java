package com.amaap.pokergame.model.domain;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
    HEARTS("H"), DIAMONDS("D"), CLUBS("C"), SPADES("S");

    private final String keyword;
    private static final Map<String, Suit> keywordMap = new HashMap<>();

    static {
        for (Suit suit : Suit.values()) {
            keywordMap.put(suit.keyword, suit);
        }
    }

    Suit(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public static Suit fromKeyword(String keyword) {
        return keywordMap.get(keyword.toUpperCase());
    }
}
