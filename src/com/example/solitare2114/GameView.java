package com.example.solitare2114;

import android.view.TouchDelegate;
import com.example.solitare2114.controller.CardController;
import view.SolitareView;
import com.example.solitare2114.model.SolitareGame;
import com.example.solitare2114.model.Deck;
import com.example.solitare2114.model.Rule;
import com.example.solitare2114.model.Hand;
import view.HandView;
import sofia.app.ShapeScreen;
import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * this is a public class dealing with how the game looks once
 * the app is booted and dealt.
 *
 *  @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
 *  & Pelin Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class GameView extends ShapeScreen
{

    SolitareGame game;
    SolitareView view;
    CardController control;


    @Override
    public void initialize() {
        game = new SolitareGame();
        view = new SolitareView(game);
        control = new CardController(view, this);

        view.addToScreen(getShapeView());
    }



    public void onTouchDown(float x, float y) {
        control.onTouchDown(x, y);

    }


    public void onTouchMove(float x, float y) {
        control.onTouchMove(x, y);
    }

    public void onTouchUp(float x, float y) {
        control.onTouchUp(x, y);
    }

}
