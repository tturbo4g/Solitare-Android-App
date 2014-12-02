package view;

import sofia.graphics.ShapeMotion;
import com.example.solitare2114.model.Hand;
import sofia.graphics.Color;
import android.graphics.Paint;
import com.example.solitare2114.model.Card;
import android.graphics.Canvas;
import sofia.graphics.Drawing;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
 *  & Pelin Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class CardView extends RectangleShape
{
    Card representing;
    public static float CARD_HEIGHT = 200;
    public static float CARD_WIDTH = 100;
    HandView heldIn;


    public HandView getHeldIn()
    {
        return heldIn;
    }


    public void setHeldIn(HandView heldIn)
    {
        this.heldIn = heldIn;
    }

    String text = "";


    public CardView(float top, float left, Card representing)
    {
        super(left, top, left + CARD_WIDTH, top + CARD_HEIGHT);
        this.representing = representing;
        setFillColor(Color.white);
        setColor(Color.black);
        setShapeMotion(ShapeMotion.STATIC);
        update();


    }


    public void update() {
        if(!representing.facedUp()) {
            setFillColor(Color.red);
            text = "";
        } else {
            setFillColor(Color.white);
            text = representing.suit().name().charAt(0)+"" + representing.value();
        }
    }

    public Card getRepresented() {
        return representing;
    }

    @Override
    public void draw(Drawing in) {
        super.draw(in);
        Canvas c = in.getCanvas();
        Paint inpaint = new Paint();
        inpaint.setTextSize(40f);
        float y1 = getTop() + (CARD_HEIGHT/2);
        c.drawText(text,getLeft()+20, y1, inpaint );
      //  c.drawText(representing.suit().name(), getLeft()+20, getTop()+10, inpaint);
    }


}
