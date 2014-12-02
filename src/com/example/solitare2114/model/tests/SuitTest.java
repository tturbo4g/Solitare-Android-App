package com.example.solitare2114.model.tests;
import com.example.solitare2114.model.SuitColor;
import com.example.solitare2114.model.Suit;

// -------------------------------------------------------------------------
/**
 * Test the suits are behaving as expected
 *
 *  @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
 *  & Pelin Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class SuitTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests to see if suits have the rights colors assigned to them.
     */
    public void testSuitColor()
    {
        assertEquals(Suit.CLUBS.color(), SuitColor.BLACK);
        assertEquals(Suit.HEARTS.color(), SuitColor.RED);
        assertEquals(Suit.SPADES.color(), SuitColor.BLACK);
        assertEquals(Suit.DIAMONDS.color(), SuitColor.BLACK);
    }
}
