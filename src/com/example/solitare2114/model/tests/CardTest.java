package com.example.solitare2114.model.tests;
import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Suit;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 * Demir (pelind@vt.edu)
 *@version Nov 17, 2014
 */
public class CardTest extends student.TestCase
{
    Card kingDiamonds;
    Card queenSpades;

    public void setUp() {
        System.out.println("TESTING");
        kingDiamonds = new Card(Card.KING, Suit.DIAMONDS);
        queenSpades  = new Card(Card.QUEEN, Suit.SPADES);
    }

    public void testValue() {
        assertEquals(kingDiamonds.value(), Card.KING);
        assertEquals(queenSpades.value(), Card.QUEEN);
    }

    public void testSuit() {
        assertEquals(kingDiamonds.suit(), Suit.DIAMONDS);
    }

    public void testFlip() {
        assertFalse(kingDiamonds.facedUp());
        kingDiamonds.flipOver();
        assertTrue(kingDiamonds.facedUp());
    }

}
