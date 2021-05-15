package org.example.diary.payload.request;

import java.util.Date;

public class CallBackRequest {
    private Long id;
    private String title;
    private String text;
    private String email;
    private Date date;

    public CallBackRequest(Long id, String title, String text, String email, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.email = email;
        this.date=date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
