package com.example.solitare2114.model;

public class Card
{
    int val;
    boolean facedUp;
    Suit suit;

    public Card(int val, Suit suit)
    {
        super();
        this.val = val;
        this.suit = suit;
        facedUp = false;
    }
    public int value()
    {
        return val;
    }
    public Suit suit()
    {
        return suit;
    }

    boolean facedUp()
    {
        return facedUp;
    }

    void flipOver()
    {
       facedUp = !facedUp;
    }
    public static final int ACE   =   0;
    public static final int KING  =  13;
    public static final int QUEEN =  12;
    public static final int JACK  =  11;



}
