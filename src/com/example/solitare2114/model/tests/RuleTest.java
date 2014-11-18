package com.example.solitare2114.model.tests;

import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Suit;
import com.example.solitare2114.model.Hand;
import com.example.solitare2114.model.Rule;

// -------------------------------------------------------------------------
/**
 * @author abryant
 * @version Nov 17, 2014
 */
public class RuleTest
    extends student.TestCase
{

    /**
     * rule that will always say you can add card
     */
    Rule alwaysTrue;

    /**
     * rule that will always say you cannot add card
     */
    Rule alwaysFalse;


    public void setUp()
    {
        alwaysTrue = new Rule() {

            public boolean canAdd(Hand in, Card c)
            {
                return true;
            }

        };
        alwaysFalse = new Rule() {

            public boolean canAdd(Hand in, Card c)
            {
                return false;
            }
        };

    }


    // ----------------------------------------------------------
    /**
     * tests the rule and other rule method in rule class
     */
    public void testAnd()
    {
        assertFalse(alwaysTrue.and(alwaysFalse).canAdd(null, null));
    }


    // ----------------------------------------------------------
    /**
     * tests rule or other rule method in rule class
     */
    public void testOr()
    {
        assertTrue(alwaysTrue.or(alwaysFalse).canAdd(null, null));
    }


    // ----------------------------------------------------------
    /**
     * tests not method in rule class
     */
    public void testNot()
    {
        assertTrue(alwaysFalse.not().canAdd(null, null));
    }


    // ----------------------------------------------------------
    /**
     * tests the value rule method in the rule class.
     */
    public void testValueRule()
    {
        Rule.ValueRule king = new Rule.ValueRule(Card.KING);
        assertTrue(king.canAdd(null, new Card(Card.KING, Suit.DIAMONDS)));
        assertFalse(king.canAdd(null, new Card(Card.QUEEN, Suit.CLUBS)));
    }

}
