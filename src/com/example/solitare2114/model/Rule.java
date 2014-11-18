package com.example.solitare2114.model;


// -------------------------------------------------------------------------
/**
 * this is an abstract class for imposing rules at certain times when the
 * player is trying to add a card to a hand.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public abstract class Rule
{

    // ----------------------------------------------------------
    /**
     *
     * @param in
     * @param c
     * @return
     */
    public abstract boolean canAdd(Hand in, Card c);


    public Rule and(final Rule other)
    {
        return new Rule() {
            public boolean canAdd(Hand in, Card c)
            {
                return Rule.this.canAdd(in, c) && other.canAdd(in, c);
            }
        };
    }


    public Rule or(final Rule other)
    {
        Rule rf = new Rule() {
            public boolean canAdd(Hand in, Card c)
            {
                return Rule.this.canAdd(in, c) || other.canAdd(in, c);
            }
        };

        return rf;
    }


    public Rule not()
    {
        return new Rule() {

            @Override
            public boolean canAdd(Hand in, Card c)
            {
                return !Rule.this.canAdd(in, c);
            }

        };
    }

    public static class ValueRule extends Rule {
        int value;
        public ValueRule(int val) {
            this.value = val;
        }

        @Override
        public boolean canAdd(Hand in, Card c)
        {
            return c.value() == value;
        }
    }


}
