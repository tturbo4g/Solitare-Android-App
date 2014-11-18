package com.example.solitare2114.model;


// -------------------------------------------------------------------------
/**
 * this is an abstract class for imposing rules at certain times when the player
 * is trying to add a card to a hand.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public abstract class Rule
{

    // ----------------------------------------------------------
    /**
     * boolean canAdd tells you if you can put card c on hand in
     *
     * @param in
     *            is the hand stack that you want to add c to.
     * @param c
     *            is the card element you want to add into the hand in.
     * @return boolean of if you can add c into in.
     */
    public abstract boolean canAdd(Hand in, Card c);


    // ----------------------------------------------------------
    /**
     * anonymous subclass for making sure both rules are followed
     *
     * @param other
     *            rule is the rule you are also making sure is followed
     * @return boolean of if you can add card c onto hand in, based on both
     *         rules.
     */
    public Rule and(final Rule other)
    {
        return new Rule() {
            public boolean canAdd(Hand in, Card c)
            {
                return Rule.this.canAdd(in, c) && other.canAdd(in, c);
            }
        };
    }


    /**
     * this for making sure one of the rules is followed
     *
     * @param other
     *            rule is the other rule you are making sure that it is being
     *            followed if the first one is not.
     * @return boolean of if you can add card c onto hand in, based on both
     *         rules.
     */
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


    // ----------------------------------------------------------
    /**
     * tells you that you cannot add card c into hand in
     *
     * @return true if not able to add
     */
    public Rule not()
    {
        return new Rule() {

            public boolean canAdd(Hand in, Card c)
            {
                return !Rule.this.canAdd(in, c);
            }

        };
    }


    // -------------------------------------------------------------------------
    /**
     * subclass for the rules involving numbers.
     *
     * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
     *         Demir (pelind@vt.edu)
     * @version Nov 17, 2014
     */
    public static class ValueRule
        extends Rule
    {
        /**
         * is value of card trying to be added
         */
        int value;


        // ----------------------------------------------------------
        /**
         * Create a new ValueRule object.
         *
         * @param val
         *            is the value of the card
         */
        public ValueRule(int val)
        {
            this.value = val;
        }


        /**
         * boolean for if the card can be added into the hand
         */
        public boolean canAdd(Hand in, Card c)
        {
            return c.value() == value;
        }
    }

}
