package com.example.solitare2114.controller;

import com.example.solitare2114.GameView;

public abstract class Controller
{
    GameView view;

    public Controller(GameView gv) {
        view = gv;
    }

    public abstract void onTouchDown (float x, float y);
    public abstract void onTouchMove (float x, float y);
    public abstract void onTouchUp   (float x, float y);

    public GameView getView() {
        return view;
    }
}
