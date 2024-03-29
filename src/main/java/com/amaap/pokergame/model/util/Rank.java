package com.amaap.pokergame.model.util;

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
}
