package com.ksumobileapp.Schedule;
import java.util.ArrayList;

public class CourseModel {
    public String courseName;
    public String courseCode;
    public String time;
    public ArrayList<String> prerequisites;


    public CourseModel(String name, String code){
        this.courseName = name;
        this.courseCode = code;
    }

    public void setPrerequisites(ArrayList<String> prerequisites){
        this.prerequisites = prerequisites;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getName(){
        return courseName;
    }

    public String getCode(){
        return courseCode;
    }

    public ArrayList<String> getPrerequisites(){
        return prerequisites;
    }


}
