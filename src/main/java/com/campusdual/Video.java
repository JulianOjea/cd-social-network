package com.campusdual;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Video extends Post{

    String title;
    String quality;
    int duration;

    public Video(int id, LocalDate date, String title, String quality, int duration) {
        super(id, date);
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String showPost() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String strdate = super.getDate().format(formatters);

        return "Video{" +
                "title='" + title + '\'' +
                "date='" + strdate + '\'' +
                ", quality='" + quality + '\'' +
                ", duration=" + duration +
                '}';
    }
}
