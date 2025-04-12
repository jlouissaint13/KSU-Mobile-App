package com.ksumobileapp.ScheduleBuilder;

public class CourseModel {
private String courseID,courseName,credit,schedule,prefix;
    public CourseModel(String courseID,String courseName,String credit,String schedule,String prefix) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
        this.schedule = schedule;
        this.prefix = prefix;
    }

}
