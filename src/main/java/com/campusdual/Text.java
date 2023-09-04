package com.campusdual;

import java.util.Calendar;

public class Text extends Post{
    private String content;

    public Text(int id, Calendar date, String content) {
        super(id, date);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String showPost() {
        return "Text{" +
                "content='" + content + '\'' +
                '}';
    }
}
