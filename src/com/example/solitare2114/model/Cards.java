package com.example.solitare2114.model;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// -------------------------------------------------------------------------
/**
 * this is the class for the stack of cards objects.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class Cards
    implements Iterable<Card>
{
    //FIELDS

    /**
     * list full of card objects.
     */
    List<Card> cards;


    // ----------------------------------------------------------
    /**
     * Create a new Cards object.
     *
     * @param incards
     *            is the list of card objects
     */
    public Cards(List<Card> incards)
    {
        this();
        cards.addAll(incards);
    }


    // ----------------------------------------------------------
    /**
     * Create a new Cards object.
     */
    public Cards()
    {
        cards = new ArrayList<Card>();
    }


    /**
     * iterator method to iterate throught the cards
     */
    public Iterator<Card> iterator()
    {
        return cards.iterator();
    }


    /**
     * getter for the top card of the cards list
     * @return card which is the top card
     */
    public Card topCard()
    {
        return cards.get(0);
    }

}
