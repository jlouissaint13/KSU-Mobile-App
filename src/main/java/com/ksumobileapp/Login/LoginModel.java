package com.ksumobileapp.Login;

public class LoginModel {
    private String campusEmail,password;

    public LoginModel(String campusEmail,String password) {
        this.campusEmail = campusEmail;
        this.password = password;
    }

    public void setCampusEmail(String campusEmail) {
        this.campusEmail = campusEmail;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCampusEmail() {
        return this.campusEmail;
    }
    public String getPassword() {
        return this.password;
    }
}
