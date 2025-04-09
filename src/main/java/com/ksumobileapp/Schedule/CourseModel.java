package com.ksumobileapp.Schedule;
import java.util.HashSet;

public class CourseModel {
    public String courseName;
    public String courseCode;
    public HashSet<CourseModel> preReqs;

    public CourseModel(String name, String code){
        this.courseName = name;
        this.courseCode = code;
        this.preReqs = new HashSet<CourseModel>();
    }

    //Add prerequisites
    public void addPreReqs(CourseModel course){
        preReqs.add(course);
    }

    //Check if the course has prerequisites
    public boolean hasPreReqs(){
        return !preReqs.isEmpty();
    }

    //Check if student can enroll in course
    public boolean canEnroll(HashSet<CourseModel> completedCourses){
        return completedCourses.containsAll(preReqs);
    }

    public String getCourseName(){return courseName;}
    public String getCourseCode(){return courseCode;}

    @Override
    public String toString(){
        return courseCode + " - " + courseName;
    }

}
