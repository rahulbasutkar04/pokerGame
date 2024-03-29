package com.amaap.pokergame.model.util;

import com.amaap.pokergame.model.domain.Card;
import com.amaap.pokergame.model.domain.Suit;

import java.util.List;

public interface StraightFlushCheck  {

     boolean isStraightFlushCheck(List<Card> cards);
}
