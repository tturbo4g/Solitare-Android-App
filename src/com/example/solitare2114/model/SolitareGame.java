package com.example.solitare2114.model;
import java.util.ArrayList;
import java.util.List;

// -------------------------------------------------------------------------
/**
 * public abstract class
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class SolitareGame
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
    List<BottomPile>        handsInPlay;

    Hand drawingSourceHand;
    Hand drawingDumpHand;


    // ----------------------------------------------------------
    /**
     * Create a new SolitareGame object.
     */
    public SolitareGame()
    {
        mainDeck = new Deck();

        handsInPlay = new ArrayList<BottomPile>();
        for (int i = 0; i < HANDS_IN_PLAY; i++)
        {
            handsInPlay.add(new BottomPile(i + 1, mainDeck));
        }

        winningPiles = new ArrayList<Hand>();
        for (Suit s : Suit.values())
        {

            Rule winningHand = (Rule.EMPTY.and(new Rule.ValueRule(Card.ACE)) ).or(Rule.EMPTY.not().and((new Rule() {

                public boolean canAdd(Hand in, Card c)
                {
                    return c.suit() == in.peek().suit();
                }
            }.and(new Rule() {

                public boolean canAdd(Hand in, Card c)
                {
                    return c.value() == in.peek().value() + 1;
                }

            }))));

            winningPiles.add(new Hand(winningHand));
        }

        drawingSourceHand = new Hand(Rule.ACCEPT_ALL.not());
        drawingSourceHand.forceAddAll(mainDeck.drawFromTop(mainDeck.remainingCards()-1));
       // drawingSourceHand.peek().flipOver();

        drawingDumpHand = new Hand(Rule.ACCEPT_ALL.not());
    }


    // ----------------------------------------------------------
    /**
     * getBottomHands of SolitareGame
     * @return the hand that is in play
     */
    public List<BottomPile> getBottomHands()
    {
        return handsInPlay;
    }


    // ----------------------------------------------------------
    /**
     * getWinningHands of SolitareGame
     * @return winning piles
     */
    public List<Hand> getWinningHands()
    {
        return winningPiles;
    }

    public Hand getDrawingFrom()
    {
        return drawingSourceHand;
    }
    public Hand getDrawingTo() {
        return drawingDumpHand;
    }


}
