package com.example.guesstheceleb;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends Fragment {
    private StateListener listener;
    private TextView score;
    private TextView message;
    private int timeRemaining;

    public StatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        // setup access to its views
        message = view.findViewById(R.id.message);
        score = view.findViewById(R.id.score);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }

    public void setMessage(String text) {
        message.setText(text);
    }

    public void setScore(String text) {
        score.setText(text);
    }
}
