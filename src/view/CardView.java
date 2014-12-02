package view;

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
    public static float CARD_HEIGHT = 20;
    public static float CARD_WIDTH = 20;



    public CardView(float top, float left, Card representing)
    {
        super();
        this.representing = representing;
    }



    @Override
    public void draw(Drawing in) {
        super.draw(in);
        Canvas c = in.getCanvas();
        Paint inpaint = new Paint();
        c.drawText( c.toString(), getLeft(), getTop(), inpaint );
    }


}
