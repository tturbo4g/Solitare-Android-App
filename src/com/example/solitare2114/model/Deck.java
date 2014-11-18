package com.example.solitare2114.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

// -------------------------------------------------------------------------
/**
 * this class is for the deck that is drawn from.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class Deck
{
    /**
     *
     */
    Stack<Card> cards;


    // ----------------------------------------------------------
    /**
     * 'draws' a card from the top
     *
     * @param nToDraw
     * @return the top card
     */
    public List<Card> drawFromTop(int nToDraw)
    {
        List<Card> ans = new ArrayList<Card>();
        for (int i = 0; i < nToDraw; i++)
            ans.add(pop());
        return ans;
    }


    // ----------------------------------------------------------
    /**
     * pop method for the stack cards
     * @return the top card
     */
    public Card pop()
    {
        return cards.pop();
    }


    // ----------------------------------------------------------
    /**
     * public boolean for the stack cards to see if empty.
     * @return if the stack cards is empty or not.
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }


    // ----------------------------------------------------------
    /**
     * Create a new Deck object.
     */
    public Deck()
    {
        cards = new Stack<Card>();

        List<Card> cards2 = new ArrayList<Card>();

        for (Suit s : Suit.values())
        {
            for (int i = 0; i <= Card.KING; i++)
            {
                cards2.add(new Card(i, s));
            }
        }

        Collections.shuffle(cards2);
        for (Card c : cards2)
        {
            cards.push(c);
        }
    }

}
