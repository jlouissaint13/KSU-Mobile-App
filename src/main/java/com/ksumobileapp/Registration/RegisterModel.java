package com.ksumobileapp.Registration;


public class RegisterModel {
    private String fname, lname, email, phone, dob, classification, major;

    public RegisterModel(String fname,String lname,String email,String phone,String dob,String classification,String major) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.classification = classification;
        this.major = major;
    }

}
