package com.example.guesstheceleb;

import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.Question;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GameUnitTest {
    @Test
    public void testGame() {
        Question[] questions = new Question[3];
        String[] answers = new String[] {"bob", "jane", "harry"};
        for (int i = 0; i < 3; ++i) {
            questions[i] = new Question(answers[i], null, answers);
        }
        Game game = new Game(questions);

        while (game.isGameOver()) {
            Question question = game.next();
            game.updateScore(question.check("bob"));
        }
        assertEquals("Score: 1/3", game.getScore());
    }
}