package com.example.seapp.ui.notifications;

public class modelnotification {
    private String userid;
    private String username;
    private String comment;

    public modelnotification() {
    }

    public modelnotification(String userid, String username, String comment) {
        this.userid = userid;
        this.username = username;
        this.comment = comment;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
