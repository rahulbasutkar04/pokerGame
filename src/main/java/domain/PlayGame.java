package domain;

import domain.Card;
import domain.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {


    public static boolean start(String name) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Player user = new Player();
        System.out.println("Welcome, " + name + "!");

        List<Card> userHand = new ArrayList<>(); // List to store user's hand

        for (int i = 0; i < 5; i++) {
            Card dealtCard = deck.getCards().remove(0); // Remove the top card from the deck
            user.selectCard(dealtCard);
            userHand.add(dealtCard); // Add the dealt card to the user's hand list
        }
        System.out.println(userHand);

        return userHand.size()!=0;
    }
}
