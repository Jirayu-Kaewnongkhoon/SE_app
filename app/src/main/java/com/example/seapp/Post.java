package com.example.seapp;

public class Post {
    private String postKey;
    private String userid;
    private String detail;
    private String pic;
    private String name;

    public Post(){

    }

    public Post(String userid, String detail, String name) {
        this.userid = userid;
        this.detail = detail;
        this.name = name;
        //this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
