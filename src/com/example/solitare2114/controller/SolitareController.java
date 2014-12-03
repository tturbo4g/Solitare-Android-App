package com.example.solitare2114.controller;

import view.HandView.HandShape;
import com.example.solitare2114.model.Hand;
import view.HandView;
import view.CardView;
import com.example.solitare2114.model.Card;
import view.SolitareView;
import com.example.solitare2114.model.Cards;
import com.example.solitare2114.GameView;

// -------------------------------------------------------------------------
/**
 * This is the controller class for the solitaire app.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class SolitareController
{

    // FIELDS
    /**
     * This is a set of cards being dragged by the user.
     */
    Cards        dragging;
    /**
     * Field for a solitaire view object
     */
    SolitareView view;
    /**
     * Field for a GameView object
     */
    GameView     game;

    /**
     * LastX is a field for the x location of the previous location of the card.
     */
    float        lastX;
    /**
     * LastY is a field for the y location of the previous location of the card.
     */
    float        lastY;


    // ----------------------------------------------------------
    // PUBLIC METHODS

    /**
     * Create a new SolitareController object.
     *
     * @param view2
     *            is the solitaire view object
     * @param gameView
     *            is the gameview object
     */
    public SolitareController(SolitareView view2, GameView gameView)
    {
        view = view2;
        game = gameView;
    }


    // ----------------------------------------------------------
    /**
     * onTouchDown of SolitareController
     *
     * @param x
     *            is x location of where user touches
     * @param y
     *            is y location of where user touches
     */
    public void onTouchDown(float x, float y)
    {
        startDraggingCards(x, y);
    }


    // ----------------------------------------------------------
    /**
     * startDraggingCards of SolitareController
     *
     * @param x
     *            is x value of where the user's finger is currently dragging.
     * @param y
     *            is y value of where the user's finger is currently dragging
     */
    public void startDraggingCards(float x, float y)
    {
        CardView thisCard = cardAt(x, y);
        if (thisCard == null)
            return;
        Card c = thisCard.getRepresented();

        Hand from = c.getCurrentHand();

        Cards startingToDrag = from.cardsStartingFrom(c);

        dragging = startingToDrag;
        liftUpHand(dragging);
        lastX = thisCard.getLeft();
        lastY = thisCard.getTop();

    }


    // ----------------------------------------------------------
    /**
     * onTouchMove of SolitareController
     *
     * @param x
     *            is the x value of where the user's finger is
     * @param y
     *            is the y value of where the user's finger is
     */
    public void onTouchMove(float x, float y)
    {
        if (dragging != null)
        {
            dragCards(dragging, x, y);
        }
    }


    // ----------------------------------------------------------
    /**
     * onTouchUp of SolitareController for when the user lifts their finger off
     * of the screen
     *
     * @param x
     *            is the last x location the user touched before lifting their
     *            finger off the screen
     * @param y
     *            is the last y location the user touched before lifting their
     *            finger off the screen
     */
    public void onTouchUp(float x, float y)
    {

        HandView handv = handAt(x, y);
        if (handv != null)
        {
            Hand from = dragging.topCard().getCurrentHand();
            Hand to = handv.getRepresented();
            dragCardsToHand(dragging, handv);
            if (!from.moveCardsTo(to, dragging))
            {
                returnDragging();
            }

            updateHandCards(from);
            updateHandCards(to);

        }
        else
        {
            returnDragging();
        }

    }


    // ----------------------------------------------------------
    /**
     * updateHandCards of SolitareController calls update() from CardView
     *
     * @param update
     *            is hand whos image is to be updated
     */
    public void updateHandCards(Hand update)
    {
        int i = 5;
        for (Card c : update)
        {
            view.getViewFor(c).update();
            view.getViewFor(c).resetIndex(i++, game.getShapeView());
        }
    }


    // ----------------------------------------------------------
    /**
     * getter for card at the location of x, y
     *
     * @param x
     *            the x value where we want to know the card
     * @param y
     *            the y value where we want to know the card
     * @return the value of the front most card at x y
     */
    public CardView cardAt(float x, float y)
    {
        return game.getShapes().locatedAt(x, y).withClass(CardView.class)
            .front();

    }


    // ----------------------------------------------------------
    /**
     * /** getter for a hand at the location of x, y
     *
     * @param x
     *            the x value where we want to know the hand
     * @param y
     *            the y value where we want to know the hand
     * @return the value of the front most card in the card stack at x y
     */
    public HandView handAt(float x, float y)
    {
        HandShape hs =
            game.getShapes().locatedAt(x, y)
                .withClass(HandView.HandShape.class).front();
        if (hs == null)
            return null;
        return hs.getHand();
    }


    // ----------------------------------------------------------
    /**
     * returnDragging of SolitareController for when user drags a card stack to
     * an incorrect location, so it needs to be returned to its starting point.
     */
    public void returnDragging()
    {
        dragCards(dragging, lastX, lastY);
        dragging = null;
    }


    // ----------------------------------------------------------
    /**
     * liftUpHand of SolitareController lifts the cards is the cards stack that
     * is below
     *
     * @param liftUp
     *            is the card stack to be moved
     */
    public void liftUpHand(Cards liftUp)
    {
        int i = 60;
        for (Card c : liftUp)
        {
            CardView cv = view.getViewFor(c);
            cv.resetIndex(i++, game.getShapeView());
        }
    }


    // ----------------------------------------------------------
    /**
     * dragCardsToHand of SolitareController
     *
     * @param drag is the cards being dragged to a new hand
     * @param view1 is the hand view for when the user is dragging the
     * list of cards, drag
     */
    public void dragCardsToHand(Cards drag, HandView view1)
    {
        dragCards(drag, view1.left, view1.getNextTop());

    }


    // ----------------------------------------------------------
    /**
     * dragCards of SolitareController drags the card stack toDrag to the
     * location dragX, dragY
     * @param toDrag is the cards being dragged onto new location
     * @param dragX is the x value of the new location
     * @param dragY is the y value of the new location
     */
    public void dragCards(Cards toDrag, float dragX, float dragY)
    {
        float y = dragY;
        for (Card c : toDrag)
        {
            CardView cv = view.getViewFor(c);
            cv.setLeft(dragX);
            cv.setTop(y);
            y += HandView.CARD_INDENT;
        }
    }

}
