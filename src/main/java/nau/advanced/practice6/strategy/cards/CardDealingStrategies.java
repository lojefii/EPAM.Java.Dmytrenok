package nau.advanced.practice6.strategy.cards;

import nau.advanced.practice6.strategy.cards.strategies.TexasHoldemStrategy;
import nau.advanced.practice6.strategy.cards.strategies.ClassicPokerCardDealingStrategy;
import nau.advanced.practice6.strategy.cards.strategies.BridgeCardDealingStrategy;
import nau.advanced.practice6.strategy.cards.strategies.FoolCardDealingStrategy;


public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasHoldemStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ClassicPokerCardDealingStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return new BridgeCardDealingStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        return new FoolCardDealingStrategy();
    }
}