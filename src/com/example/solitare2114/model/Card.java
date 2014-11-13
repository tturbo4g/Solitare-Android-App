package com.example.solitare2114.model;

public abstract class Card
{
    abstract int value();
    abstract Suit suit();

    public static final int ACE   =   0;
    public static final int KING  =  13;
    public static final int QUEEN =  12;
    public static final int JACK  =  11;


}
