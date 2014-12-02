package view;

import sofia.graphics.ShapeView;
import com.example.solitare2114.model.Hand;
import com.example.solitare2114.model.SolitareGame;

public class SolitareView
{
    SolitareGame game;



    public SolitareView(SolitareGame in ) {
        game = in;
    }

    public void addToScreen(ShapeView addTo) {

        float bottomHandsY = addTo.getHeight() * .75f;
        float bottomHandsX = addTo.getWidth() / 9.0f;
        System.out.println("y: "+bottomHandsY+" x: "+bottomHandsX);
        int index = 0;
        for(Hand h : game.getBottomHands()) {
            HandView hv = new HandView(bottomHandsY, bottomHandsX * ( (index++ )+1), h);
            hv.addToWorld(addTo);
        }


    }




}
