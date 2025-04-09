package com.ksumobileapp.Schedule;
import java.util.HashSet;

public class CourseModel {
    public String courseName;
    public String courseCode;
    public HashSet<CourseModel> preReqs;

    public CourseModel(String name, String code, HashSet<CourseModel> preReqs){
        this.courseName = name;
        this.courseCode = code;
        this.preReqs = preReqs;
    }

    public String getCourseName(){return courseName;}
    public String getCourseCode(){return courseCode;}

}
