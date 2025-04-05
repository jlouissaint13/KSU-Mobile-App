package com.ksumobileapp.Login;

public class LoginModel {
    private String campusEmail,password;
    //we will use this email so we can identify the user who is currently logged in;
    private static String email;
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
    public static void setCurrentUser(String email) {
        LoginModel.email = email;
    }
    public static String getCurrentUser() {
        return email;
    }

}
