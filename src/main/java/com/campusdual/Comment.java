package com.campusdual;

import java.util.Calendar;

public class Comment {

    private String text;
    private Calendar date;
    private User owner;

    public Comment(String text, Calendar date, User owner) {
        this.text = text;
        this.date = date;
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
