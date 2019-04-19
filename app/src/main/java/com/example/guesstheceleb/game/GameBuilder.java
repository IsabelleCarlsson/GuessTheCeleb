package com.example.guesstheceleb.game;

import android.graphics.Bitmap;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameBuilder {
    private CelebrityManager celebrityManager;

    public GameBuilder(CelebrityManager celebrityManager) {
        this.celebrityManager = celebrityManager;
    }

    public Game create(Difficulty difficulty) {
        int n;
        switch (difficulty) {
            case EASY:
                n = 3;
                break;

            case MEDIUM:
                n = 6;
                break;

            case HARD:
                n = 12;
                break;

            case EXPERT:
                n = 24;
                break;

            default:
                n = 0;
                break;
        }
        return new Game(constructQuestions(n));
    }

    private Question[] constructQuestions(int n) {
        Set<Integer> randIntSet = new HashSet<>();
        String[] nameList = new String[n];
        Question[] questions = new Question[n];

        while (randIntSet.size() < n) {
            randIntSet.add(new Random().nextInt(celebrityManager.count()));
        }
        Integer[] celebIndexes = randIntSet.toArray(new Integer[n]);

        for (int i = 0; i < n; i++) {
            String celebName = celebrityManager.getName(celebIndexes[i]);
            nameList[i] = celebName;
        }
        for (int i = 0; i < n; i++) {
            String celebName = celebrityManager.getName(celebIndexes[i]);
            Bitmap celebImage = celebrityManager.get(celebIndexes[i]);
            questions[i] = new Question(celebName, celebImage, nameList);
        }
        return questions;
    }
}
