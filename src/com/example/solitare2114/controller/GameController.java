package com.example.solitare2114.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.solitare2114.GameView;

public class GameController extends Controller
{
    public GameController(GameView gv)
    {
        super(gv);
        myControllers = new ArrayList<Controller>();
    }

    List<Controller> myControllers;

    @Override
    public void onTouchDown(float x, float y)
    {
        for(Controller c : myControllers)
            c.onTouchDown(x, y);
    }

    @Override
    public void onTouchMove(float x, float y)
    {
       for(Controller c : myControllers)
           c.onTouchMove(x, y);
    }

    @Override
    public void onTouchUp(float x, float y)
    {
        for(Controller c : myControllers)
            c.onTouchUp(x, y);
    }

    public void addController(Controller in) {
        myControllers.add(in);
    }


}
