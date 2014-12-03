package view;

import sofia.graphics.ShapeView;
import sofia.graphics.ShapeMotion;
import sofia.graphics.Color;
import android.graphics.Paint;
import com.example.solitare2114.model.Card;
import android.graphics.Canvas;
import sofia.graphics.Drawing;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * view class for a card object.
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class CardView
    extends RectangleShape
{
    // FIELDS

    /**
     * field for the card that we are making a view for
     */
    Card                representing;

    /**
     * card height for the game, with default setting 200
     */
    public static float CARD_HEIGHT = 200;

    /**
     * card width for the game, with default setting 100
     */
    public static float CARD_WIDTH  = 100;

    /**
     * hand view object that the card is being held in
     */
    HandView            heldIn;


    // ----------------------------------------------------------
    /**
     * getter for the handview object that the current card is in
     *
     * @return heldIn hand view of the hand the card is in
     */
    public HandView getHeldIn()
    {
        return heldIn;
    }


    // ----------------------------------------------------------
    /**
     * setter for the handview object that the current card is to be held in
     *
     * @param heldIn
     *            hand view of the new hand
     */
    public void setHeldIn(HandView heldIn)
    {
        this.heldIn = heldIn;
    }

    /**
     *
     */
    String text = "";


    // ----------------------------------------------------------
    /**
     * Creates a new cardview object
     *
     * @param top
     * @param left
     * @param representing
     */
    public CardView(float top, float left, Card representing)
    {
        super(left, top, left + CARD_WIDTH, top + CARD_HEIGHT);
        this.representing = representing;
        setFillColor(Color.white);
        setColor(Color.black);
        setShapeMotion(ShapeMotion.STATIC);
        update();

    }


    // ----------------------------------------------------------
    /**
     * updates the card showing. if face down it is red, if face up it puts
     * appropriate values on card
     */
    public void update()
    {

        if (!representing.facedUp())
        {
            setFillColor(Color.red);
            text = "";
        }
        else
        {
            setFillColor(Color.white);
            text =
                representing.suit().name().charAt(0) + ""
                    + representing.value();
        }
    }


    // ||
    // ASK GREG ABOUT READD \ /
    // ----------------------\/------------------------------------
    /**
     * readd of CardView
     *
     * @param add
     *            shaoe view object.
     */
    public void readd(ShapeView add)
    {
        this.remove();
        add.add(this);
    }


    // ----------------------------------------------------------
    /**
     * resets the Index of the hand
     *
     * @param zIndex
     * @param addBack
     */
    public void resetIndex(int zIndex, ShapeView addBack)
    {
        this.remove();
        this.setZIndex(zIndex);
        addBack.add(this);
    }


    // ----------------------------------------------------------
    /**
     * gets the card value of what the shape view is representing
     *
     * @return representing
     */
    public Card getRepresented()
    {
        return representing;
    }


    /**
     * draws the object
     *
     * @param in
     *            is the drawing object
     */
    public void draw(Drawing in)
    {
        super.draw(in);
        Canvas c = in.getCanvas();
        Paint inpaint = new Paint();
        inpaint.setTextSize(40f);

        float y1 = getTop() + (CARD_HEIGHT / 2);
        c.drawText(text, getLeft() + 20, y1, inpaint);
        // c.drawText(representing.suit().name(), getLeft()+20, getTop()+10,
// inpaint);
    }

}
