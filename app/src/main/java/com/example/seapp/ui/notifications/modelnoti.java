package com.example.seapp.ui.notifications;

public class modelnoti extends modelnotification {
    public modelnoti(String username, String postKey) {
        this.username = username;
        this.postKey = postKey;
    }
public modelnoti(){
}
    private String username;
    private String postKey;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }



}
