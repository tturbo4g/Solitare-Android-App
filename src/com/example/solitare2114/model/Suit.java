package com.example.solitare2114.model;

// -------------------------------------------------------------------------
/**
 * this is the enum value for each of the four suits a card can be. Also, each
 * suit is assigned the appropriate color.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public enum Suit
{

    /**
     * clubs enum value, and is set as black.
     */
    CLUBS(SuitColor.BLACK, "♣"),

    /**
     * diamonds enum value, and is set as red.
     */
    DIAMONDS(SuitColor.RED, "♦"),

    /**
     * Hearts enum value, and is set as red.
     */
    HEARTS(SuitColor.RED, "♥"),

    /**
     * spades enum value, and is set to black.
     */
    SPADES(SuitColor.BLACK, "♠");

    /**
     *suit color for card
     */
    SuitColor clr;
    String rep;


    // ----------------------------------------------------------
    /**
     * getter for the color of the suit.
     *
     * @return clr which is the color.
     */
    public SuitColor color()
    {
        return clr;
    }

    public String character() {
        return rep;
    }


    Suit(SuitColor c, String rep)
    {
        clr = c;
        this.rep = rep;
    }


}
