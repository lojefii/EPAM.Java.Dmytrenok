package nau.advanced.practice6.strategy.cards.strategies;

import nau.advanced.practice6.strategy.cards.Card;

public class CardImpl implements Card {
    private String name;

    public CardImpl(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}