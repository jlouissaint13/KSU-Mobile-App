package com.ksumobileapp.Registration;


public class RegisterModel {
    private String fname, lname, email, password, phone, dob, classification, major,race,gender,address;
    private static String studentID;
    String[] data;
    public RegisterModel(String fname, String lname, String phone, String email, String password, String address, String gender, String race, String dob, String classification, String major) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.race = race;
        this.dob = dob;
        this.classification = classification;
        this.major = major;
        data = new String[11];
    }

    //Setters
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public static void setStudentID(String studentID) {
        RegisterModel.studentID = studentID;
    }
    public static String getStudentID() {
        return RegisterModel.studentID;
    }
    public static void resetStudentID() {RegisterModel.studentID = null;}
    public void setData() {
        data[0] = this.fname;
        data[1] = this.lname;
        data[2] = this.phone;
        data[3] = this.email;
        data[4] = this.password;
        data[5] = this.address;
        data[6] = this.gender;
        data[7] = this.race;
        data[8] = this.dob;
        data[9] = this.classification;
        data[10] = this.major;
    }

    public void setAll(String fname, String lname, String phone, String email, String password, String address, String gender, String race, String dob, String classification, String major) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.race = race;
        this.dob = dob;
        this.classification = classification;
        this.major = major;
    }
   //Getters
   public String getFname() {
       return this.fname;
   }

    public String getLname() {
        return this.lname;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public String getGender() {
        return this.gender;
    }

    public String getRace() {
        return this.race;
    }

    public String getDob() {
        return this.dob;
    }

    public String getClassification() {
        return this.classification;
    }

    public String getMajor() {
        return this.major;
    }

}
