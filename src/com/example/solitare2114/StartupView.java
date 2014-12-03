package com.example.solitare2114;

import sofia.graphics.RectangleShape;
import android.content.Intent;
import sofia.app.Screen;
//import sofia.app.Screen;
//import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * this public class deals with what the app will look like when the app is just
 * starting up, before the game is dealt.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class StartupView
    extends Screen
{
    // ----------------------------------------------------------

    /**
     * what to do when the start game button is clicked.
     */
    public void startGameButtonClicked()
    {
        Intent open = new Intent(this, GameView.class);
        startActivity(open);
    }

    @Override
    public void initialize() {
    //    getWindow().setBackgroundDrawableResource(R.drawable.bg);

    }



}
