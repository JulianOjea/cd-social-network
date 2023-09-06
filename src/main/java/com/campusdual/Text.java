package com.campusdual;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Text extends Post{
    private String content;

    public Text(int id, LocalDate date, String content) {
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
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String strdate = super.getDate().format(formatters);

        return "Text{" +
                "content='" + content + '\'' +
                "date='" + strdate + '\'' +
                '}';
    }
}
