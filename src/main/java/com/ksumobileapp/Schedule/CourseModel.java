package com.ksumobileapp.Schedule;
import java.util.List;

public class CourseModel {
    private String courseName;
    private String courseCode;
    public List<CourseModel> preReqs;

    public CourseModel(String name, String code, List<CourseModel> preReqs){
        this.courseName = name;
        this.courseCode = code;
        this.preReqs = preReqs;
    }

    public String getCourseName(){return courseName;}
    public String getCourseCode(){return courseCode;}

}
