package com.example.agrotwin.model.domain;

public class FontSizeManager {
    private static FontSizeManager instance;
    private int textSize = 18;

    private FontSizeManager() {}

    public static FontSizeManager getInstance() {
        return instance == null ?
                instance = new FontSizeManager() : instance;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
}

