package com.example.guesstheceleb;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guesstheceleb.game.Difficulty;
import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.GameBuilder;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements StateListener {
    private GameFragment gameFragment;
    private StatusFragment statusFragment;
    private QuestionFragment questionFragment;
    private StateListener listener;
    private GameBuilder gameBuilder;
    private boolean isLargeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        gameFragment = (GameFragment) fragmentManager.findFragmentById(R.id.game);
        statusFragment = (StatusFragment) fragmentManager.findFragmentById(R.id.status);
        questionFragment = (QuestionFragment) fragmentManager.findFragmentById(R.id.question);
        isLargeScreen = statusFragment != null;
    }

    @Override
    public void onUpdate(State state) {
        Difficulty level = gameFragment.getLevel();
        String text = String.format(Locale.getDefault(), "state: %s level %s", state, level);
        Log.i("MainActivity", text);

        if (isLargeScreen) {
            switch (state) {
                case START_GAME:
                    Game game = gameBuilder.create(level);
                    questionFragment.setGame(game);
                    break;
//
//                case CONTINUE_GAME:
//                    statusFragment.setScore(questionFragment.getScore());
//                    break;
//
//                case GAME_OVER:
//                    statusFragment.setScore(questionFragment.getScore());
//                    statusFragment.setMessage("Game over");
//                    break;
            }
        } else {

        }
    }
}
