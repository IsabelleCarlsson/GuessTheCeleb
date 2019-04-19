package com.example.guesstheceleb;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.guesstheceleb.game.Difficulty;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {
    private StateListener listener;
    private Difficulty level;

    public GameFragment() {
        // Required empty public constructor
    }
    public Difficulty getLevel() { return level; }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_game, container, false);
        final Spinner spinner = view.findViewById(R.id.difficulty);

        // handle button click by triggering state listener update
        view.findViewById(R.id.play).setOnClickListener((v) -> {
            String selection = spinner.getSelectedItem().toString();
            Log.i("GameFragment", "selection: " + selection);
            level = Difficulty.valueOf(selection.toUpperCase());
            listener.onUpdate((State.START_GAME));
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
