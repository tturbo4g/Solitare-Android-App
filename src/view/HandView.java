package view;

import sofia.graphics.ShapeMotion;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.graphics.ShapeView;
import com.example.solitare2114.model.Card;
import com.example.solitare2114.model.Hand;

// -------------------------------------------------------------------------
/**
 *  This is the view class for the hand
 *
* @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
 *  & Pelin Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class HandView
{

    /**
     * Indentation of cards in a hand (if the indentation is active)
     */
    public static float CARD_INDENT = 30;

    /**
     * Hand that this view represents.
     */
    Hand                representing;

    /**
     * The top of the root of this hand
     */
    public float        top;

    /**
     * the left edge of this hand
     */
    public float        left;

    /**
     * whether or not this hand indents its cards
     */
    boolean             indent;

    /**
     * The master view that this was created from
     */
    SolitareView        createdFrom;


    /**
     * The shape that represents the root of this hand - visible when
     * hand is empty
     */
    HandShape           me;



    // ----------------------------------------------------------
    /**
     * Create a new HandView object.
     * @param solview the root solitare view
     * @param top the top coordinate of the hand
     * @param left the left edge of the hand
     * @param in the hand to represent
     * @param indent whether or not this hand indents its cards
     */
    public HandView(
        SolitareView solview,
        float top,
        float left,
        Hand in,
        boolean indent)
    {
        solview.handViews.put(in,  this);
        this.indent = indent;
        createdFrom = solview;

        this.top = top;
        this.left = left;

        representing = in;
        float totalIndent = 0;
        int index = 0;
        for (Card c : representing)
        {
            CardView cview =
                new CardView(top + (indent ? totalIndent : 0), left, c);
            solview.views.put(c, cview);
            cview.setHeldIn(this);
            cview.setZIndex(index++);
            totalIndent += CARD_INDENT;
        }

    }

    // ----------------------------------------------------------
    /**
     * refresh the positions of the cards in this hand. Ensures everything
     * is realigned.
     */
    public void refresh() {
        float y = top;
        for(Card c : representing) {
            CardView cv = createdFrom.getViewFor(c);
            cv.setLeft(left);
            cv.setTop(y);
            y += (indent)?CARD_INDENT:0;
        }
    }


    // ----------------------------------------------------------
    /**
     * get the hand that this view represents
     * @return represented hand
     */
    public Hand getRepresented()
    {
        return representing;
    }


    // ----------------------------------------------------------
    /**
     * adds the cards in this hand to a given ShapeView
     * @param view the view to add the represented cards to
     */
    public void addToWorld(ShapeView view)
    {
        me = new HandShape(left, top, this);
        view.add(me);

        for (Card c : representing)
        {
            view.add(createdFrom.getViewFor(c));
        }
    }


    // ----------------------------------------------------------
    /**
     * calculates the top coordinate for a next card to be added to this
     * hand
     *
     * @return the top coordinate for the next card
     */
    public float getNextTop()
    {
        return top + representing.size() * (indent ? CARD_INDENT : 0);
    }


    // -------------------------------------------------------------------------
    /**
     *  This shape represents an empty hand - a pale grey rectangle the size of
     *  a card.
     *
     * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
     *  & Pelin Demir (pelind@vt.edu)
     *  @version Nov 17, 2014
     */
    public static class HandShape
        extends RectangleShape
    {
        /**
         * HandView to point back to
         */
        HandView held;


        // ----------------------------------------------------------
        /**
         * Create a new HandShape rectangle.
         * @param left left coordinate
         * @param top top coordinate
         * @param hv the handview to point back to.
         */
        public HandShape(float left, float top, HandView hv)
        {
            super(left, top, left + CardView.CARD_WIDTH, top
                + CardView.CARD_HEIGHT);
            setFillColor(Color.gray.brighter());
            setZIndex(-1);
            this.held = hv;
            setShapeMotion(ShapeMotion.STATIC);
        }


        // ----------------------------------------------------------
        /**
         * get the represented {@link HandView}
         * @return the HandView this came from
         */
        public HandView getHand()
        {
            return held;
        }

    }

}
