package com.campusdual;

import java.text.SimpleDateFormat;
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
        String strdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        strdate = sdf.format(super.getDate().getTime());

        return "Text{" +
                "content='" + content + '\'' +
                "date='" + strdate + '\'' +
                '}';
    }
}
