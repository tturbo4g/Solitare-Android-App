package com.example.solitare2114.model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import java.util.Collection;

public abstract class SolitareGame
{

    public static final int HANDS_IN_PLAY = 7;

    Deck mainDeck;

    List<Hand> winningPiles;

    List<Hand> handsInPlay;

    public SolitareGame() {
        mainDeck = new Deck();

        Rule inPlayHands = new Rule() {

            @Override
            public boolean canAdd(Hand in, Card c)
            {
                return in.isEmpty() && c.value() == Card.KING;
            }

        }
        .or( (
    new Rule() {

            @Override
            public boolean canAdd(Hand in, Card c)
            {
                // Checks to make sure they're opposite colors
                Card existing = in.peek();
                return existing.suit().color() != c.suit().color();
            }
        }.and(new Rule() {
            @Override
            public boolean canAdd(Hand in, Card c)
            {
                Card existing = in.peek();
                return existing.value() - 1 == c.value();
            }
        })));

        handsInPlay = new ArrayList<Hand>();
        for(int i = 0; i < HANDS_IN_PLAY ; i++) {
            handsInPlay.add(new Hand(inPlayHands));
        }


        winningPiles = new ArrayList<Hand>();
        for(Suit s : Suit.values()) {

            Rule winningHand = new Rule() {
                public boolean canAdd(Hand in, Card c) {
                    return in.isEmpty() && c.value() == Card.ACE;
                }
            }.or( ( new Rule() {
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

            }) ) );

            winningPiles.add(new Hand(winningHand));
        }




    }






}
