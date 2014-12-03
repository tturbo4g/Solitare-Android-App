package com.example.solitare2114.model.tests;
import android.R;
import android.widget.*;
import com.example.solitare2114.StartupView;

// -------------------------------------------------------------------------
/**
 *  This is the StartupViewTest class. It ensures that the initial view of the
 *  game is as expected.
 *
 *
 *  @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
 *  & Pelin Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public class StartupViewTest extends student.AndroidTestCase<StartupView>
{
    /**
     * Button to be clicked to start the game
     */
    Button startGameButton;

    // ----------------------------------------------------------
    /**
     * This creates a new StartupViewTest object.
     */
    // ----------------------------------------------------------

    public StartupViewTest()
    {
        super(StartupView.class);

    }

    // ----------------------------------------------------------
    /**
     * Tests the functioning of ButtonStartGame.
     */
    public void testButtonStartGame()
    {
        assertEquals(startGameButton.isClickable(), true);
       // click(getScreen().findViewById(R.id.startGameButton));
        assertEquals(startGameButton.isActivated(), true);
    }
}
