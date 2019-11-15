package com.example.seapp;

public class User {
    public String username;
    public String fname;
    public String lname;
    public String userType; // ใน หรือ นอกสถาบัน
    public String inType; //นศ / บุคลากร
    public String pic;

    public User(String fname,String lname,String userType,String inType){
        this.username = username;
        this.lname =  lname;
        this.userType = userType;
        this.inType = inType;

    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
