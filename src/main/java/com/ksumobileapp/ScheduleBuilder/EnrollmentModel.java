package com.ksumobileapp.ScheduleBuilder;

import java.util.ArrayList;

public class EnrollmentModel {
private String courseID,courseName,credit,semester,prefix,schedule,studentID;
private ArrayList<String> prerequisites;
    public EnrollmentModel(String studentID,String courseID, String courseName, String credit, String prefix,String semester,String schedule) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
        this.prefix = prefix;
        this.semester = semester;
        this.schedule = schedule;
    }
    public EnrollmentModel() {

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

    public String getSchedule() {
        return schedule;
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

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public void setPrerequisites(ArrayList<String> prerequisites) {

        this.prerequisites = prerequisites;

    }
    public ArrayList<String> getPrerequisites() {
        return this.prerequisites;
    }


}
