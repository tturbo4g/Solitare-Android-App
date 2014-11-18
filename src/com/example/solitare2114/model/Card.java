package com.example.solitare2114.model;


/**
 *  this class is for implementing the behavior of a card.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 * Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class Card
{
    /**number value of card
     *
     */
    int val;

    /**
     *boolean of if the card is face up or not
     */
    boolean facedUp;

    /**
     * suit value of the card
     */
    Suit suit;

    // ----------------------------------------------------------
    /**
     * Create a new Card object.
     * @param val int value of card to be created
     * @param suit suit of card to be created
     */
    public Card(int val, Suit suit)
    {
        super();
        this.val = val;
        this.suit = suit;
        facedUp = false;
    }
    // ----------------------------------------------------------
    /**
     *getter for value of card
     * @return number value of card
     */
    public int value()
    {
        return val;
    }

    // ----------------------------------------------------------
    /**
     * getter for suit value of card
     * @return suit of card
     */
    public Suit suit()
    {
        return suit;
    }

    // ----------------------------------------------------------
    /**
     * getter for if card is face up.
     * @return boolean of if face up or not.
     */
    public boolean facedUp()
    {
        return facedUp;
    }

    // ----------------------------------------------------------
    /**
     *flips over the card so its values are visible
     */
    public void flipOver()
    {
       facedUp = !facedUp;
    }
    /**
     * number value of ace
     */
    public static final int ACE   =   0;

    /**
     *number value of king
     */
    public static final int KING  =  13;

    /**
     *number value of queen
     */
    public static final int QUEEN =  12;

    /**
     *number value of jack
     */
    public static final int JACK  =  11;



}
