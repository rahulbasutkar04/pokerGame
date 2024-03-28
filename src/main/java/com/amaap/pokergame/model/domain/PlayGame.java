package com.amaap.pokergame.model.domain;

import com.amaap.pokergame.model.exception.EmptyCardException;
import com.amaap.pokergame.model.exception.InvalidCardTypeException;
import com.amaap.pokergame.model.exception.InvalidNumberOfCardException;
import com.amaap.pokergame.model.exception.cardAlreadyExistException;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PlayGame {

    private Set<Card> userHand = new LinkedHashSet<>();

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

            if (rank == null || suit == null) {
                continue;
            }

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

    public Set<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(Set<Card> userHand) {
        this.userHand = userHand;
    }

    private static boolean isValidCardFormat(String token) {
        return token.matches("[2-9TJQKA][HDSC]");
    }


}
