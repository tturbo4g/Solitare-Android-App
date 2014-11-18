package com.example.solitare2114.model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import java.util.Collection;

// -------------------------------------------------------------------------
/**
 * public abstract class
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public abstract class SolitareGame
{

    /**
     * this is the value for the number of hands still in play. starts as seven
     * but can get smaller if the player clears entire decks.
     */
    public static final int HANDS_IN_PLAY = 7;

    /**
     * this is the main deck that the player gets cards from to add on to hands
     * in play.
     */
    Deck                    mainDeck;

    /**
     * these are the piles at the top in which the ultimate goal of the game is
     * to get all cards from handsinplay onto their respecive winningpiles
     */
    List<Hand>              winningPiles;

    /**
     * these are the piles of card in which are not in the maindeck or
     * winningPiles
     */
    List<Hand>              handsInPlay;


    // ----------------------------------------------------------
    /**
     * Create a new SolitareGame object.
     */
    public SolitareGame()
    {
        mainDeck = new Deck();

        Rule inPlayHands = new Rule() {

            public boolean canAdd(Hand in, Card c)
            {
                return in.isEmpty() && c.value() == Card.KING;
            }

        }.or((new Rule() {


            public boolean canAdd(Hand in, Card c)
            {
                // Checks to make sure they're opposite colors
                Card existing = in.peek();
                return existing.suit().color() != c.suit().color();
            }
        }.and(new Rule() {

            public boolean canAdd(Hand in, Card c)
            {
                Card existing = in.peek();
                return existing.value() - 1 == c.value();
            }
        })));

        handsInPlay = new ArrayList<Hand>();
        for (int i = 0; i < HANDS_IN_PLAY; i++)
        {
            Hand thisHand = new Hand(inPlayHands);
            handsInPlay.add(thisHand);

            /* Add the appropriate number of cards to each hand */

        }

        winningPiles = new ArrayList<Hand>();
        for (Suit s : Suit.values())
        {

            Rule winningHand = new Rule() {
                public boolean canAdd(Hand in, Card c)
                {
                    return in.isEmpty() && c.value() == Card.ACE;
                }
            }.or((new Rule() {
                @Override
                public boolean canAdd(Hand in, Card c)
                {
                    return c.suit() == in.peek().suit();
                }
            }.and(new Rule() {

                @Override
                public boolean canAdd(Hand in, Card c)
                {
                    return c.value() == in.peek().value() + 1;
                }

            })));

            winningPiles.add(new Hand(winningHand));

        }

    }

}
