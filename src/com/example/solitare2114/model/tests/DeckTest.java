package com.example.solitare2114.model.tests;
import com.example.solitare2114.model.Deck;
import com.example.solitare2114.model.Card;

// -------------------------------------------------------------------------
/**
 *  test class for the Deck.javaclass in solitare2114.model
 *
 *@author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class DeckTest extends student.TestCase
{
    /**
     * test deck field
     */
    Deck testDeck;

    public void setUp()
    {
        testDeck = new Deck();
    }

    // ----------------------------------------------------------
    /**
     * tests the drawFromTop method in deck class.
     */
    public void testDrawFromTop()
    {
        testDeck.drawFromTop(3);
        assertEquals(testDeck.remainingCards(), 49);
        testDeck.drawFromTop(0);
        assertEquals(testDeck.remainingCards(), 49);
    }

    // ----------------------------------------------------------
    /**
     * tests pop method in deck class
     */
    public void testPop()
    {
        Card testCardPop = testDeck.pop();
        assertEquals(testDeck.remainingCards(), 48);
        assertNotNull(testCardPop);
    }

    // ----------------------------------------------------------
    /**
     * test isEmpty() method in deck class.
     */
    public void testIsEmpty()
    {
        assertFalse(testDeck.isEmpty());
        testDeck.drawFromTop(48);
        assertTrue(testDeck.isEmpty());
        assertEquals(testDeck.remainingCards(), 0);
    }


}
