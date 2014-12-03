package com.example.solitare2114;

import com.example.solitare2114.controller.SolitareController;
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
    SolitareController control;

    public static volatile Object syncObject = new Object();


    @Override
    public void initialize() {
       // this.getShapeView().setAutoRepaint(false);
        game = new SolitareGame();
        view = new SolitareView(game);
        control = new SolitareController(view, this);

        view.addToScreen(getShapeView());

        /*
        new Thread(new Runnable() {

            @Override
            public void run()
            {
                synchronized(syncObject) {
                    GameView.this.getShapeView().repaint();
                }
                try
                {
                    Thread.sleep(15);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        }).start();*/

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

    public SolitareGame getGame() {
        return game;
    }
    public SolitareView getGameView() {
        return view;
    }

}
