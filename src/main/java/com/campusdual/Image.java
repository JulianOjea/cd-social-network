package com.campusdual;

import java.util.Calendar;

public class Image extends Post{

    private String title;
    private int height;
    private int width;

    public Image(int id, Calendar date, String title, int height, int width) {
        super(id, date);
        this.title = title;
        this.height = height;
        this.width = width;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String showPost() {
        return "Image{" +
                "title='" + title + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
