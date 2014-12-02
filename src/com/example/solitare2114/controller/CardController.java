package com.example.solitare2114.controller;

import view.HandView.HandShape;
import com.example.solitare2114.model.Hand;
import android.view.DragEvent;
import android.view.View.OnDragListener;
import sofia.graphics.ShapeView;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.example.solitare2114.GameView;
import view.SolitareView;
import view.CardView;
import view.HandView;

public class CardController
{
    SolitareView view;
    GameView activity;

    CardView dragging;
    int oldZdex;
    float startingX, startingY;
    HandView cameFrom;


    public void onTouchDown(float x, float y ) {
        System.out.println("TOUCHED");
        ShapeView shapes = activity.getShapeView();

        CardView cv = shapes.getShapes().locatedAt(x, y).withClass(CardView.class).front();

        if(cv == null)
            return;

        dragging = cv;
        oldZdex = dragging.getZIndex();
        dragging.setZIndex(99);
        startingX = dragging.getLeft();
        startingY = dragging.getTop();
        cameFrom = dragging.getHeldIn();

    }
    public void onTouchMove(float x, float y) {
        if(dragging != null) {
            dragging.setLeft(x);
            dragging.setTop(y);
        }
    }
    public void onTouchUp(float x, float y) {
        if(dragging != null) {
        //    dragging.setZIndex(oldZdex);

            dragging.setLeft(startingX);
            dragging.setTop(startingY);

            dragging = null;
            HandShape hs = activity.getShapes().locatedAt(x, y).withClass(HandView.HandShape.class).front();

        }

    }

    public CardController(SolitareView sv, GameView gv) {
        view = sv;
        activity = gv;




    }





}
