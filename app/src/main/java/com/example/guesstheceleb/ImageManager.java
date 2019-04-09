package com.example.guesstheceleb;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class ImageManager {
    private String assetPath;
    private String[] imageNames;
    private AssetManager assetManager;

    ImageManager(AssetManager assetManager, String assetPath) {
        this.assetManager = assetManager;
        this.assetPath = assetPath;
        try {
            this.imageNames = assetManager.list(assetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Bitmap get(int i) {
        try {
            InputStream stream = assetManager.open(assetPath + "/" + imageNames[i]);
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
