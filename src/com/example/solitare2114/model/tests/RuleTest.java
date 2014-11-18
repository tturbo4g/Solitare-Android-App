package com.example.solitare2114.model.tests;

import com.example.solitare2114.model.Suit;
import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Hand;
import com.example.solitare2114.model.Rule;

// -------------------------------------------------------------------------
/**
 *
 *  @author abryant
 *  @version Nov 17, 2014
 */
public class RuleTest extends student.TestCase
{

    Rule alwaysTrue;
    Rule alwaysFalse;

    public void setUp() {
        alwaysTrue = new Rule() {

            @Override
            public boolean canAdd(Hand in, Card c)
            {
                return true;
            }

        };
        alwaysFalse = new Rule() {
            @Override
            public boolean canAdd(Hand in, Card c)
            {
                return false;
            }
        };


    }

    public void testAnd() {
        assertFalse(alwaysTrue.and(alwaysFalse).canAdd(null, null));
    }

    public void testOr() {
        assertTrue(alwaysTrue.or(alwaysFalse).canAdd(null, null));
    }

    public void testNot() {
        assertTrue(alwaysFalse.not().canAdd(null, null));
    }

    public void testValueRule() {
        Rule.ValueRule king = new Rule.ValueRule(Card.KING);
        assertTrue(king.canAdd(null, new Card(Card.KING, Suit.DIAMONDS)));
        assertFalse(king.canAdd(null,  new Card(Card.QUEEN, Suit.CLUBS)));
    }

}
