package com.ksumobileapp.Registration;


public class RegisterModel {
    private String fname, lname, email, password, phone, dob, classification, major;
    String[] data;
    public RegisterModel(String fname,String lname,String email,String password,String phone,String dob,String classification,String major) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.classification = classification;
        this.major = major;
        data = new String[8];
    }
    //Setters
    public void setFname(String fname) {
        this.fname = fname;
   }
   public void setLname(String lname) {
        this.lname = lname;
   }
   public void setEmail(String email) {
        this.email = email;
   }
   public void setPassword(String password) {
        this.password = password;
   }
   public void setPhone(String phone) {
        this.phone = phone;
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
   public void setData() {
        data[0] = this.fname;
        data[1] = this.lname;
        data[2] = this.email;
        data[3] = this.password;
        data[4] = this.phone;
        data[5] = this.phone;
        data[6] = this.dob;
        data[7] = this.classification;
        data[8] = this.major;
   }

   public void setAll(String fname,String lname,String email,String password,String phone,String dob,String classification,String major) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phone = phone;
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
   public String getEmail() {
        return this.email;
   }
   public String getPassword() {
        return this.password;
   }
   public String getPhone() {
        return this.phone;
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
