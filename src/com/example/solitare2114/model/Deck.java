package com.example.solitare2114.model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Deck
{
    Stack<Card> cards;

    public List<Card> drawFromTop(int nToDraw){
        List<Card> ans = new ArrayList<Card>();
        for(int i = 0; i < nToDraw; i++)
            ans.add(pop());
        return ans;
    }

    public Card pop() {
        return cards.pop();
    }

    public Deck() {


    }

    private class InnerCard extends Card {
        int val;
        Suit suit;
        public InnerCard(int val, Suit suit)
        {
            super();
            this.val = val;
            this.suit = suit;
        }
        public int value()
        {
            return val;
        }
        public Suit suit()
        {
            return suit;
        }

    }
}
