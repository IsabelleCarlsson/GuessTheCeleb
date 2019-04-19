package com.example.guesstheceleb;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.guesstheceleb.game.CelebrityManager;
import com.example.guesstheceleb.game.Difficulty;
import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.GameBuilder;
import com.example.guesstheceleb.game.Question;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GameInstrumentedTest {
    @Test
    public void testGameBuilder() {
        Context context = InstrumentationRegistry.getTargetContext();
        AssetManager assetManager = context.getAssets();
        CelebrityManager celebrityManager = new CelebrityManager(assetManager, "celebs");

        GameBuilder gameBuilder = new GameBuilder(celebrityManager);
        Game game = gameBuilder.create(Difficulty.EXPERT);

        int corractlyAnswered = 0;
        loop: while (game.isGameOver()) {
            Question question = game.next();
            for (int i = 0; i < celebrityManager.count(); ++i) {
                Log.i("GameInstrumentedTest", celebrityManager.getName(i));
                if (question.check(celebrityManager.getName(i))) {
                    ++corractlyAnswered;
                    continue loop;
                }
            }
            fail("didn't answer question correctly");
        }
        assertEquals(game.count(), corractlyAnswered);
    }
}
