package com.campusdual;

import java.util.Calendar;

public class Video extends Post{

    String title;
    String quality;
    int duration;

    public Video(int id, Calendar date, String title, String quality, int duration) {
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
        return "Video{" +
                "title='" + title + '\'' +
                ", quality='" + quality + '\'' +
                ", duration=" + duration +
                '}';
    }
}
