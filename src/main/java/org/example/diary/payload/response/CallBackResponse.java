package org.example.diary.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.diary.entity.CallBack;

import java.util.Date;

public class CallBackResponse {
    private Long id;
    private String title;
    private String text;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public CallBackResponse(Long id, String title, String text, String email, Date date) {
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

    public static CallBackResponse from(CallBack callBack){
        return new CallBackResponse(callBack.getId(),
                callBack.getTitle(),
                callBack.getText(),
                callBack.getUser().getEmail(),
                callBack.getDate());
    }
}
