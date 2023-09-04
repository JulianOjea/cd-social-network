package com.campusdual;

import java.util.Calendar;
import java.util.List;

public abstract class Post {

    private Calendar date;
    private List<Comment> commentList;
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

    public Post(int id, Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
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
