package com.example.solitare2114.model.tests;

import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Suit;

// -------------------------------------------------------------------------
/**
 * test class for card
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class CardTest
    extends student.TestCase
{
    /**
     * king of diamonds card
     */
    Card kingDiamonds;
    /**
     * queen of spades card
     */
    Card queenSpades;


    public void setUp()
    {
        System.out.println("TESTING");
        kingDiamonds = new Card(Card.KING, Suit.DIAMONDS);
        queenSpades = new Card(Card.QUEEN, Suit.SPADES);
    }


    // ----------------------------------------------------------
    /**
     * tests the value getter for card class
     */
    public void testValue()
    {
        assertEquals(kingDiamonds.value(), Card.KING);
        assertEquals(queenSpades.value(), Card.QUEEN);
    }


    // ----------------------------------------------------------
    /**
     * tests the suit getter for card class
     */
    public void testSuit()
    {
        assertEquals(kingDiamonds.suit(), Suit.DIAMONDS);
    }


    // ----------------------------------------------------------
    /**
     * tests flip over method in card class
     */
    public void testFlip()
    {
        assertFalse(kingDiamonds.facedUp());
        kingDiamonds.flipOver();
        assertTrue(kingDiamonds.facedUp());
    }

}
