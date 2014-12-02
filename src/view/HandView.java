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
    List<CardView> cardsInHand;

    public float top, left;
    float lastTop;

    public void update() {
        for(CardView cv : cardsInHand)
            cv.update();
    }






    public HandView(float top, float left, Hand in, boolean indent) {
        this.top = top;
        this.left = left;

        cardsInHand = new ArrayList<CardView>();
        representing = in;
        float totalIndent = 0;
        int index = 0;
        for(Card c : representing) {
            CardView cview = new CardView(top+(indent?totalIndent:0), left, c);
            cview.setHeldIn(this);
            cview.setZIndex(index++);
            cardsInHand.add(cview);
            totalIndent += CARD_INDENT;
            lastTop = top+(indent?totalIndent:0);
        }

    }

    public CardView getTopCardView() {
        return cardsInHand.get(cardsInHand.size()-1);
    }

    public Hand getRepresented() {
        return representing;
    }

    public void addToWorld(ShapeView view) {
        HandShape empty = new HandShape(left, top, this);
        view.add(empty);


        for(CardView cv : cardsInHand) {
            view.add(cv);
        }
    }

    public void clear() {
        for(CardView cv : cardsInHand) {
            cv.remove();
        }
        cardsInHand.clear();
    }

    public void addCard(CardView in) {
        if(!in.heldIn.representing.isEmpty())
            in.heldIn.representing.pop();
        if(!in.heldIn.representing.isEmpty() && !in.heldIn.representing.peek().facedUp()) {
            in.heldIn.representing.peek().flipOver();
            in.heldIn.update();
        }
        in.setHeldIn(this);
        representing.add(in.getRepresented());
        in.setLeft(left);
        in.setTop(lastTop + CARD_INDENT);
        lastTop += CARD_INDENT;
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

    public void removeTop()
    {
        cardsInHand.remove(cardsInHand.size()-1);
    }


}
