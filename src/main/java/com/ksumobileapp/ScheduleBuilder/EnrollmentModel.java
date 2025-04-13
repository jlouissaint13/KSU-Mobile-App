package com.ksumobileapp.ScheduleBuilder;

public class EnrollmentModel {
private String courseID,courseName,credit,semester,prefix,time,studentID;
    public EnrollmentModel(String studentID,String courseID, String courseName, String credit, String prefix,String semester,String time) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
        this.prefix = prefix;
        this.semester = semester;
        this.time = time;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCredit() {
        return credit;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSemester() {
        return semester;
    }

    public String getTime() {
        return time;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
