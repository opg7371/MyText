package com.filmygeekstudio.mytext;

/**
 * Created by piyush on 10/1/16.
 */
public class Contact {

    String fname,lname,email,uname,pass;
    Double mobile;

    public String getEmail() {
        return this.email;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public Double getMobile() {
        return this.mobile;
    }

    public String getPass() {
        return this.pass;
    }

    public String getUname() {
        return this.uname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setMobile(Double mobile) {
        this.mobile = mobile;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
