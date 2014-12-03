package view;

import sofia.graphics.ShapeMotion;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import java.util.ArrayList;
import sofia.graphics.ShapeView;
import com.example.solitare2114.model.Card;
import java.util.List;
import com.example.solitare2114.model.Hand;

public class HandView
{
    public static float CARD_INDENT = 10;

    Hand representing;

    public float top, left;


    boolean indent;
    SolitareView createdFrom;

    HandShape me;




    public HandView(SolitareView solview,
        float top, float left, Hand in, boolean indent) {
        this.indent = indent;
        createdFrom = solview;

        this.top = top;
        this.left = left;

        representing = in;
        float totalIndent = 0;
        int index = 0;
        for(Card c : representing) {
            CardView cview = new CardView(top+(indent?totalIndent:0), left, c);
            solview.views.put(c,  cview);
            cview.setHeldIn(this);
            cview.setZIndex(index++);
            totalIndent += CARD_INDENT;
        }

    }

    public Hand getRepresented() {
        return representing;
    }

    public void addToWorld(ShapeView view) {
        me = new HandShape(left, top, this);
        view.add(me);


        for(Card c : representing) {
            view.add(createdFrom.getViewFor(c));
        }
    }

    public float getNextTop() {
        return top + representing.size() * (indent?CARD_INDENT:0);
    }


    public static class HandShape extends RectangleShape {
        HandView held;
        public HandShape(float left, float top, HandView hv) {
            super(left, top, left + CardView.CARD_WIDTH, top + CardView.CARD_HEIGHT);
            setFillColor(Color.gray.brighter());
            setZIndex(-1);
            this.held = hv;
            setShapeMotion(ShapeMotion.STATIC);
        }

        public HandView getHand() {
            return held;
        }

    }



}
