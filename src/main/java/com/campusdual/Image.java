package com.campusdual;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Image extends Post{

    private String title;
    private int height;
    private int width;

    public Image(int id, LocalDate date, String title, int height, int width) {
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
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String strdate = super.getDate().format(formatters);

        return "Image{" +
                "title='" + title + '\'' +
                "date='" + strdate + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
