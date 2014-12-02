package view;

import sofia.graphics.ShapeView;
import com.example.solitare2114.model.Hand;
import com.example.solitare2114.model.SolitareGame;

public class SolitareView
{
    SolitareGame game;

    public HandView drawTo, drawFrom;

    public SolitareView(SolitareGame in ) {
        game = in;
    }

    public void addToScreen(ShapeView addTo) {

        float bottomHandsY = addTo.getHeight() * .75f;
        float bottomHandsX = addTo.getWidth() / 8.0f;
        System.out.println("y: "+bottomHandsY+" x: "+bottomHandsX);
        int index = 0;
        for(Hand h : game.getBottomHands()) {
            HandView hv = new HandView(bottomHandsY, bottomHandsX * ( (index++ )+.5f), h,true);
            hv.addToWorld(addTo);
        }

        float topHandsY = addTo.getHeight() * .25f;
        float topHandsX = addTo.getWidth() / 6;
        index = 0;
        for(Hand h : game.getWinningHands()) {
            HandView hv = new HandView(topHandsY, topHandsX * ((index++) +2), h, true);
            hv.addToWorld(addTo);
        }

        drawFrom = new HandView(topHandsY, topHandsX - 40, game.getDrawingFrom(), false);
        drawTo = new HandView(topHandsY, topHandsX+CardView.CARD_WIDTH - 38, game.getDrawingTo(), false);
        drawFrom.addToWorld(addTo);
        drawTo.addToWorld(addTo);


    }

    public SolitareGame getGame() {
        return game;
    }




}
