package view;

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

    float top, left;




    public HandView(float top, float left, Hand in) {
        this.top = top;
        this.left = left;

        cardsInHand = new ArrayList<CardView>();
        representing = in;
        float totalIndent = 0;
        int index = 0;
        for(Card c : representing) {
            CardView cview = new CardView(top+totalIndent, left, c);
            cview.setHeldIn(this);
            cview.setZIndex(index++);
            cardsInHand.add(cview);
            totalIndent += CARD_INDENT;
        }

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

    static class HandShape extends RectangleShape {
        HandView held;
        public HandShape(float left, float top, HandView hv) {
            super(left, top, left + CardView.CARD_WIDTH, top + CardView.CARD_HEIGHT);
            setFillColor(Color.gray.brighter());
            setZIndex(-1);
            this.held = hv;
        }

    }
}
