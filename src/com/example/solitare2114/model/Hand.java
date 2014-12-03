package com.example.solitare2114.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * this class is for hands, which are represented in stacks.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class Hand
    implements Iterable<Card>
{
    /**
     * this field is for the Stack cardsInHand which is to be made up of Cards
     */
    Stack<Card> cardsInHand;
    /**
     * this field is for the value of the rule ableToAdd, which tells us if we
     * can add one card ontop of another in a given situation.
     */
    Rule        ableToAdd;


    // ----------------------------------------------------------
    /**
     * Create a new Hand object
     *
     * @param canAdd
     */
    public Hand(Rule canAdd)
    {
        this.ableToAdd = canAdd;
        cardsInHand = new Stack<Card>();
    }


    // ----------------------------------------------------------
    /**
     * peek method to use for seeing the last card added in a deck, but not
     * removing it like pop would.
     *
     * @return the value of the top card in cardsInHand
     */
    public Card peek()
    {
        return cardsInHand.peek();
    }


    // ----------------------------------------------------------
    /**
     * pop method to use for removing the card last added to cardsInHand
     *
     * @return the value of the last added card.
     */
    public Card pop()
    {
        return cardsInHand.pop();
    }


    // ----------------------------------------------------------
    /**
     * adds the value of the card parameter to the stack cardsInHand
     *
     * @param canAdd
     *            is the card to add to the stack
     */
    public void add(Card canAdd)
    {
        if (canAdd(canAdd))
        {
            canAdd.currentlyIn = this;
            cardsInHand.add(canAdd);
        }
        else
        {
            throw new IllegalStateException("Tried to add a " + canAdd
                + " to an" + " illegal hand.");
        }
    }


    // ----------------------------------------------------------
    /**
     * checks if cardsInHand is empty or not
     *
     * @return boolean value of if the stack is or is not empty.
     */
    public boolean isEmpty()
    {
        return cardsInHand.isEmpty();
    }


    // ----------------------------------------------------------
    /**
     * force add is for dealing the cards, so that you do not have to follow the
     * rules of the game when dealing.
     *
     * @param canAdd
     *            is the card being dealt.
     */
    public void forceAdd(Card canAdd)
    {
        canAdd.currentlyIn = this;
        cardsInHand.add(canAdd);
    }


    // ----------------------------------------------------------
    /**
     * forceAddAll of Hand for dealing purposes when order of cards are going to
     * break the rules of moving them.
     *
     * @param cards
     */
    public void forceAddAll(Collection<Card> cards)
    {
        for(Card c : cards)
            forceAdd(c);
    }

    public Cards cardsStartingFrom(Card startWith) {
        int index = cardsInHand.indexOf(startWith);

//        assert(startWith.facedUp);

        return new Cards(cardsInHand.subList(index, cardsInHand.size()));
    }

    public boolean moveCardsTo(Hand moveTo, Cards whichCards) {

        if(!moveTo.canAdd(whichCards.cards.get(0))) {
            return false;
        }

        for(Card c : whichCards) {
            cardsInHand.remove(c);
            moveTo.add(c);
            c.currentlyIn = moveTo;
        }

        if(!peek().facedUp)
            peek().flipOver();

        return true;
    }


    // ----------------------------------------------------------
    /**
     * @param toAdd
     *            is card value that is trying to be added to the hand.
     * @return the boolean value of if it is able to add or not.
     */
    public boolean canAdd(Card toAdd)
    {
        return ableToAdd.canAdd(this, toAdd);
    }


    /**
     * iterator for the cards in a hand.
     */
    public Iterator<Card> iterator()
    {
        return cardsInHand.iterator();
    }


    public int size()
    {
        return cardsInHand.size();
    }
}
