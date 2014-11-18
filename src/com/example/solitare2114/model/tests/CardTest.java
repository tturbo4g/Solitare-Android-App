package com.example.solitare2114.model.tests;

import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Suit;


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
