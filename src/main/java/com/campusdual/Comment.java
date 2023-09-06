package com.campusdual;

import java.time.LocalDate;
import java.util.Calendar;

public class Comment {

    //A modo de ejemplo se generan ids de comentario a partir de este valor
    public static int idComment = 0;
    private String text;
    private LocalDate date;
    private User owner;

    public static int getIdComment() {
        return idComment;
    }

    public static void setIdComment(int idComment) {
        Comment.idComment = idComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Comment(String text, LocalDate date, User owner) {
        this.text = text;
        this.date = date;
        this.owner = owner;
        this.id = idComment;
        idComment = idComment + 1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
