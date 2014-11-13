package com.example.solitare2114.model;

import java.util.Stack;

public class Hand
{
    Stack<Card> cardsInHand;
    Rule ableToAdd;

    public Hand(Rule canAdd) {
        this.ableToAdd = canAdd;
        cardsInHand = new Stack<Card>();
    }

    public Card peek() {
        return cardsInHand.peek();
    }

    public Card pop() {
        return cardsInHand.pop();
    }

    public void add(Card canAdd) {
        if(canAdd(canAdd)) {
            cardsInHand.add(canAdd);
        } else {
            throw new IllegalStateException("Tried to add a "+canAdd+" to an" +
            		" illegal hand.");
        }
    }

    public boolean isEmpty() {
        return cardsInHand.isEmpty();
    }

    public void forceAdd(Card canAdd) {
        cardsInHand.add(canAdd);
    }
    public boolean canAdd(Card toAdd) {
        return ableToAdd.canAdd(this, toAdd);
    }
}
