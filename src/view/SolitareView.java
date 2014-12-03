package view;

import java.util.HashMap;
import java.util.Map;
import com.example.solitare2114.model.Card;
import sofia.graphics.ShapeView;
import com.example.solitare2114.model.Hand;
import com.example.solitare2114.model.SolitareGame;

// -------------------------------------------------------------------------
/**
 * this is the view class for the game of solitaire
 *
 * @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb), & Pelin
 *         Demir (pelind@vt.edu)
 * @version Nov 17, 2014
 */
public class SolitareView
{
    // FIELDS

    /**
     * Game is the field for the solitaire game in question
     */
    SolitareGame    game;

    /**
     * is the hand view object of the stack of cards that is being drawn from
     */
    public HandView drawFrom;

    /**
     * is the hand view object of the stack of cards that is being drawn to
     */
    public HandView drawTo;


    // ----------------------------------------------------------
    /**
     * Create a new SolitareView object.
     *
     * @param in
     *            is the solitaire game object
     */
    public SolitareView(SolitareGame in)
    {
        game = in;
    }


    // ----------------------------------------------------------
    /**
     * addToScreen of SolitareView
     *
     * @param addTo
     *            is the shape being added to the screen
     */
    public void addToScreen(ShapeView addTo)
    {

        // The coordinates for the hands across the bottom
        float bottomHandsY = addTo.getHeight() * .5f; // halfway down the screen
        float bottomHandsX = addTo.getWidth() / 8.0f;
            // 1/8th of the space across

        int index = 0;
        for (Hand h : game.getBottomHands())
        {
            HandView hv =
                new HandView(this, bottomHandsY, bottomHandsX
                    * ((index++) + .5f), h, true);
            hv.addToWorld(addTo);
        }

        float topHandsY = addTo.getHeight() * .25f;
        float topHandsX = addTo.getWidth() / 6;
        index = 0;
        for (Hand h : game.getWinningHands())
        {
            HandView hv =
                new HandView(
                    this,
                    topHandsY,
                    topHandsX * ((index++) + 2),
                    h,
                    false);
            hv.addToWorld(addTo);
        }

        // Move up a bit for the drawing hands.
        topHandsY -= CardView.CARD_HEIGHT * 1.25f;

        drawFrom =
            new HandView(
                this,
                topHandsY,
                topHandsX - 60,
                game.getDrawingFrom(),
                false);
        drawTo =
            new HandView(
                this,
                topHandsY,
                topHandsX + CardView.CARD_WIDTH - 50,
                game.getDrawingTo(),
                false);
        drawFrom.addToWorld(addTo);
        drawTo.addToWorld(addTo);

    }


    // ----------------------------------------------------------
    /**
     * getter for the game object
     * @return game object
     */
    public SolitareGame getGame()
    {
        return game;
    }



    /*************************************************
     *
     *   The below code provides a mapping between model code and view code
     *  that will be used by the controllers to modify the view based on
     *  information in the model. This was the best way we could find to
     *  separate these concerns. The maps are populated when the corresponding
     *  views are created, in {@link HandView}.
     *
     */

    /**
     * new map of card values and views
     */
    Map<Card, CardView> views = new HashMap<Card, CardView>();

    /**
     * The map to hold the hand views in.
     */
    Map<Hand, HandView> handViews = new HashMap<Hand, HandView>();


    // ----------------------------------------------------------
    /**
     * getter for the card view of a card of value c
     * @param c is the value of the card
     * @return the card view object for a card of value c
     */
    public CardView getViewFor(Card c)
    {
        return views.get(c);
    }

    /**
     * getter for the hand view of a hand of value h
     * @param h the hand to look for
     * @return the hand view object for h
     */
    public HandView getViewFor(Hand h)
    {
        return handViews.get(h);
    }

    /**********************************************/
}
