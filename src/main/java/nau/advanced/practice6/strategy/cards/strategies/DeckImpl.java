package nau.advanced.practice6.strategy.cards.strategies;

import nau.advanced.practice6.strategy.cards.Card;
import nau.advanced.practice6.strategy.cards.Deck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeckImpl implements Deck {
    LinkedList<Card> cards;

    public DeckImpl(int cardsAmount) {
        cards = new LinkedList<>();
        for (int i = 0; i < cardsAmount; i++) {
            cards.push(new CardImpl(Integer.toString(i)));
        }
    }

    @Override
    public Card dealCard() {
        if (cards.size() == 0) {
            return null;
        } else {
            cards.pop();
        }
        return null;
    }

    @Override
    public List<Card> restCards() {
        ArrayList<Card> rest = new ArrayList<>(cards);
        cards.clear();
        return rest;
    }

    @Override
    public int size() {
        return cards.size();
    }
}