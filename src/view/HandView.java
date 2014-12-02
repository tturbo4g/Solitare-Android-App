package view;

import sofia.graphics.ShapeView;
import com.example.solitare2114.model.Card;
import java.util.List;
import com.example.solitare2114.model.Hand;

public class HandView
{
    Hand representing;
    List<CardView> cardsInHand;

    public HandView(Hand in) {
        representing = in;
        for(Card c : representing) {
            cardsInHand.add(new CardView(10, 10, c)); // TODO
        }
    }

    public void addToWorld(ShapeView view) {
        for(CardView cv : cardsInHand) {
            view.add(cv);
        }
    }
}
