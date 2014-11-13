package com.example.solitare2114.model;

public enum Suit
{

    CLUBS(SuitColor.BLACK),
    DIAMONDS(SuitColor.RED),
    HEARTS(SuitColor.RED),
    SPADES(SuitColor.BLACK);

    SuitColor clr;
    SuitColor color() {
        return clr;
    }
    Suit(SuitColor c){
        clr = c;
    }
}
