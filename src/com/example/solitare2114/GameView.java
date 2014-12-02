package com.example.solitare2114;

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


    @Override
    public void initialize() {
        game = new SolitareGame();
        view = new SolitareView(game);

        view.addToScreen(getShapeView());

    }

}
