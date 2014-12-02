package com.example.solitare2114.model;

// -------------------------------------------------------------------------
/**
 *Bottom pile class
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 * Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class BottomPile extends Hand
{

    /**
     * is empty rule for if hand is empty
     */
    static Rule isEmptyAndKing = new Rule() {
        public boolean canAdd(Hand in, Card c)
        {
            return in.isEmpty();
        }
    }.and(new Rule.ValueRule(Card.KING));

    /**
     * different color rule for if you can add a card.
     */
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

    /**
     * new rule for adding cards into the pile
     */
    static Rule inPlayHands = isEmptyAndKing.or((diffColor.and(new Rule() {
        public boolean canAdd(Hand in, Card c)
        {
            if(in.isEmpty())
                return false;
            Card existing = in.peek();
            return existing.value() - 1 == c.value();
        }
    })));

    // ----------------------------------------------------------
    /**
     * Create a new BottomPile object.
     * @param number
     * @param drawFrom
     */
    public BottomPile(int number, Deck drawFrom) {
        super(inPlayHands);
        forceAddAll(drawFrom.drawFromTop(number));
        peek().flipOver();
    }

}
