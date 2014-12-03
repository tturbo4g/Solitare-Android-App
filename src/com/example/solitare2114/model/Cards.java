package com.example.solitare2114.model;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Cards implements Iterable<Card>
{
    List<Card> cards;

    public Cards(List<Card> incards) {
        this();
        cards.addAll(incards);
    }

    public Cards() {
        cards = new ArrayList<Card>();
    }
    @Override
    public Iterator<Card> iterator()
    {
        return cards.iterator();
    }
    public Card topCard() {
        return cards.get(0);
    }


}
