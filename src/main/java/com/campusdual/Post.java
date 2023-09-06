package com.campusdual;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Post {

    private LocalDate date;
    private List<Comment> commentList = new ArrayList<>();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
/*
    public Post(Calendar date, List<Comment> commentList) {
        this.date = date;
        this.commentList = commentList;
    }*/

    public Post(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Comment findCommentById(int id){
        for (Comment c:
             commentList) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    //--------------features

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public void deleteComment(Comment comment){
        this.commentList.remove(comment);
    }

    public abstract String showPost();

    public int getNumberOfComments(){
        return this.commentList.size();
    }
}
