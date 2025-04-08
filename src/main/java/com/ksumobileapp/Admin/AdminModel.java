package com.ksumobileapp.Admin;

public class AdminModel {
    private static String studentID;
    public AdminModel() {

    }


    public void setStudentID(String studentID) {
        AdminModel.studentID = studentID;
    }
    public String getStudentID() {
        return AdminModel.studentID;
    }
}
