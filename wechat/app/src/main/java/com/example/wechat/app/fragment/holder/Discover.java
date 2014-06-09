package com.example.wechat.app.fragment.holder;

public class Discover {
    private boolean isNew;

    private int imageSource;

    private String description;

    public Discover(String description, boolean isNew, int imageSource) {
        this.isNew = isNew;
        this.imageSource = imageSource;
        this.description = description;
    }

    public int getImageSource() {
        return imageSource;
    }
    public String getDescription() {
        return description;
    }
    public boolean isNew() {
        return isNew;
    }
}
