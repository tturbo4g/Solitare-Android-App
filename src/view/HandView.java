package view;

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

    public HandView(float top, float left, Hand in) {
        cardsInHand = new ArrayList<CardView>();
        representing = in;
        float totalIndent = 0;
        int index = 0;
        representing.peek().flipOver();
        for(Card c : representing) {
            CardView cview = new CardView(top+totalIndent, left, c);
            cview.setZIndex(index++);
            cardsInHand.add(cview);
            totalIndent += CARD_INDENT;
        }

    }

    public void addToWorld(ShapeView view) {
        for(CardView cv : cardsInHand) {
            view.add(cv);
        }
    }
}
