package com.example.guesstheceleb;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.Question;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
    private StateListener listener;
    private ListView questions;
    private Game currentGame;
    private ImageView image;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        // setup access to its views
        questions = view.findViewById(R.id.questions);
        image = view.findViewById(R.id.image);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }

    public void onItemClickView(View view) {}

    public void setGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public String getScore() {
        return currentGame.getScore();
    }

    public void showNextQuestion() {
        Question nextQuestion = currentGame.next();
        image.setImageBitmap(nextQuestion.getCelebrityImage());

        nextQuestion.getPossibleNames();
    }
}
