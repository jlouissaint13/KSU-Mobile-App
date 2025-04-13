package com.ksumobileapp.ScheduleBuilder;

public class CourseModel {
    private static String courseID;
    private static String semester;


    public static void setCourseID(String courseID) {
        CourseModel.courseID = courseID;
    }
    public static String getCourseID() {
        return courseID;
    }
    public static void setSemester(String semester) {
        CourseModel.semester = semester;
    }
    public static String getSemester() {
        return semester;
    }
}
