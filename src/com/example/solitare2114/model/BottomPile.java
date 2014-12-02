package com.example.solitare2114.model;

public class BottomPile extends Hand
{

    static Rule isEmptyAndKing = new Rule() {
        public boolean canAdd(Hand in, Card c)
        {
            return in.isEmpty();
        }
    }.and(new Rule.ValueRule(Card.KING));

    static Rule diffColor = new Rule() {

        public boolean canAdd(Hand in, Card c)
        {
            // Checks to make sure they're opposite colors
            if(in.isEmpty())
                return false;
            Card existing = in.peek();
            return existing.suit().color() != c.suit().color();
        }
    };

    static Rule inPlayHands = isEmptyAndKing.or((diffColor.and(new Rule() {
        public boolean canAdd(Hand in, Card c)
        {
            if(in.isEmpty())
                return false;
            Card existing = in.peek();
            return existing.value() - 1 == c.value();
        }
    })));

    public BottomPile(int number, Deck drawFrom) {
        super(inPlayHands);
        forceAddAll(drawFrom.drawFromTop(number));
        peek().flipOver();
    }

}
