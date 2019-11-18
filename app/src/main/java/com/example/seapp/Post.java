package com.example.seapp;

public class Post {
    public String postKey;
    public String userid;
    public String detail;
    public String pic;

    public Post(){

    }

    public Post(String userid, String detail) {
        this.userid = userid;
        this.detail = detail;
        //this.pic = pic;
    }


    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
