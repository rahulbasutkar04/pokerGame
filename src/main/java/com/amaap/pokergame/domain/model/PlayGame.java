package com.amaap.pokergame.domain.model;

import com.amaap.pokergame.domain.exception.EmptyCardException;
import com.amaap.pokergame.domain.exception.InvalidCardTypeException;
import com.amaap.pokergame.domain.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.domain.exception.cardAlreadyExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

    private List<Card> userHand = new ArrayList<>();
    public boolean start() throws InvalidNumberOfCardException, EmptyCardException, InvalidCardTypeException, cardAlreadyExistException {
        DeckOfCards deck = new DeckOfCards();
        Player user = new Player();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            throw new EmptyCardException("Input is empty.");
        }

        String[] tokens = input.split(",\\s*");
        if (tokens.length != 5) {
            throw new InvalidNumberOfCardException("Exactly five cards should be provided.");
        }

        for (String token : tokens) {
            String trimmedToken = token.trim().toUpperCase();
            if (!isValidCardFormat(trimmedToken)) {
                throw new InvalidCardTypeException("Invalid card format: " + token);
            }

            Rank rank = Rank.fromKeyword(String.valueOf(trimmedToken.charAt(0)));
            Suit suit = Suit.fromKeyword(String.valueOf(trimmedToken.charAt(1)));

            Card card = new Card(rank, suit);
            if (deck.getCards().contains(card)) {
                user.selectCard(card);
                userHand.add(card);
                deck.getCards().remove(card);
            } else {
                throw new cardAlreadyExistException("Duplicate card found");
            }
        }

        setUserHand(userHand);
        return !userHand.isEmpty();
    }

    public List<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(List<Card> userHand) {
        this.userHand = userHand;
    }

    private static boolean isValidCardFormat(String token) {
        return token.matches("[2-9TJQKA][HDSC]");
    }


    public String getHandRankFor(List<Card> cards) {
        HandEvaluator handEvaluator = new HandEvaluator();
        HandRanking handRanking = handEvaluator.evaluateHand(cards);

        return handRanking.getFullName();
    }
}
