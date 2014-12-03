package com.example.solitare2114.model.tests;
import com.example.solitare2114.model.Cards;
import java.util.Collection;
import com.example.solitare2114.model.Hand;
import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Suit;

// -------------------------------------------------------------------------
/**
 * This is a test class for the hand class.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class HandTest
    extends student.TestCase
{
    /**
     * collection of cards to test force add all method
     */
    Collection<Card> cards;

    /**
     * test hand
     */
    Hand testHand;

    /**
     * king of diamonds card
     */
    Card kingDiamonds;

    /**
     * queen of spades card
     */
    Card queenSpades;

    /**
     * jack of hearts card
     */
    Card jackHearts;

    /**
     * set up for the testing. creates a hand and a couple cards to play with
     */
    public void setUp()
    {
        kingDiamonds = new Card(Card.KING, Suit.DIAMONDS);
        queenSpades = new Card(Card.QUEEN, Suit.SPADES);
        jackHearts = new Card(Card.JACK, Suit.HEARTS);
    }

    // ----------------------------------------------------------
    /**
     * test class for hand's add method
     */
    public void testAdd()
    {
        testHand.add(queenSpades);
        assertEquals(testHand.isEmpty(), true);
        testHand.add(kingDiamonds);
        assertEquals(testHand.isEmpty(), false);
        testHand.add(queenSpades);
        assertEquals(testHand.peek().value(), queenSpades.value());
    }

    // ----------------------------------------------------------
    /**
     * test ForceAdd method from the hand class
     */
    public void testForceAdd()
    {
        testHand.forceAdd(queenSpades);
        assertEquals(testHand.isEmpty(), false);
    }

    // ----------------------------------------------------------
    /**
     * testForceAddAll method from the hands class
     */
    public void testForceAddAll()
    {
        cards.add(kingDiamonds);
        cards.add(queenSpades);
        cards.add(jackHearts);
        testHand.forceAddAll(cards);
        assertFalse(testHand.isEmpty());
    }

    // ----------------------------------------------------------
    /**
     * testCanAdd method from the hand class
     */
    public void testCanAdd()
    {
        testHand.add(queenSpades);
        assertFalse(testHand.canAdd(new Cards(kingDiamonds)));
    }

    // ----------------------------------------------------------
    /**
     * testIterator method from the hand class.
     */
    public void testIterator()
    {
        testHand.add(kingDiamonds);
        testHand.add(queenSpades);
        testHand.add(jackHearts);
        assertNotNull(testHand.iterator());

    }
}
