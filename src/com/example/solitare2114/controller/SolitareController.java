package com.example.solitare2114.controller;

import view.HandView.HandShape;
import com.example.solitare2114.model.Hand;
import view.HandView;
import view.CardView;
import com.example.solitare2114.model.Card;
import view.SolitareView;
import com.example.solitare2114.model.Cards;
import com.example.solitare2114.GameView;

public class SolitareController
{

    Cards dragging;
    SolitareView view;
    GameView game;

    float lastX, lastY;

    public SolitareController(SolitareView view2, GameView gameView)
    {
        view = view2;
        game = gameView;
    }

    public void onTouchDown(float x, float y) {
        startDraggingCards(x,y);
    }


    public void startDraggingCards(float x, float y) {
        CardView thisCard = cardAt(x,y);
        if(thisCard == null)
            return;
        Card c = thisCard.getRepresented();

        Hand from = c.getCurrentHand();

        Cards startingToDrag = from.cardsStartingFrom(c);

        dragging = startingToDrag;
        liftUpHand(dragging);
        lastX = thisCard.getLeft();
        lastY = thisCard.getTop();

    }

    public void onTouchMove(float x, float y) {
        if(dragging != null) {
            dragCards(dragging, x, y);
        }
    }


    public void onTouchUp(float x, float y) {


        HandView handv = handAt(x,y);
        if(handv != null) {
            Hand from = dragging.topCard().getCurrentHand();
            Hand to   = handv.getRepresented();
            dragCardsToHand(dragging, handv);
            if(!from.moveCardsTo(to, dragging)) {
                returnDragging();
            }

            updateHandCards(from);
            updateHandCards(to);

        } else {
            returnDragging();
        }


    }


    public void updateHandCards(Hand update) {
        int i = 5;
        for(Card c : update) {
            view.getViewFor(c).update();
            view.getViewFor(c).resetIndex(i++, game.getShapeView());
        }
    }
    public CardView cardAt(float x, float y ) {
        return game.getShapes().locatedAt(x,y).withClass(CardView.class).front();

    }
    public HandView handAt(float x, float y) {
        HandShape hs = game.getShapes().locatedAt(x,y).withClass(HandView.HandShape.class).front();
        if(hs == null)
            return null;
        return hs.getHand();
    }
    public void returnDragging() {
        dragCards(dragging, lastX, lastY);
        dragging = null;
    }

    public void liftUpHand(Cards liftUp) {
        int i = 60;
        for(Card c : liftUp) {
            CardView cv = view.getViewFor(c);
            cv.resetIndex(i++, game.getShapeView());
        }
    }

    public void dragCardsToHand(Cards drag, HandView view) {
        dragCards(drag, view.left, view.getNextTop());

    }

    public void dragCards(Cards toDrag, float dragX, float dragY) {
        float y = dragY;
        for(Card c : toDrag) {
            CardView cv = view.getViewFor(c);
            cv.setLeft(dragX);
            cv.setTop(y);
            y += HandView.CARD_INDENT;
        }
    }

}
