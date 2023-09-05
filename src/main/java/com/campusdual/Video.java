package com.campusdual;

import java.text.SimpleDateFormat;
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
        String strdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        strdate = sdf.format(super.getDate().getTime());

        return "Video{" +
                "title='" + title + '\'' +
                "date='" + strdate + '\'' +
                ", quality='" + quality + '\'' +
                ", duration=" + duration +
                '}';
    }
}
