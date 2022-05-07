package nau.advanced.practice6.strategy.cards;

import java.util.ArrayList;
import java.util.Map;

public interface CardDealingStrategy {
    Map<String, ArrayList<Card>> dealStacks(Deck deck, int players);
}