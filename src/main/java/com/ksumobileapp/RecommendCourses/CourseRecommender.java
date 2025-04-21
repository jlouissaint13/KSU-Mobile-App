package com.ksumobileapp.RecommendCourses;

import com.ksumobileapp.Login.LoginModel;

import java.sql.*;
import java.util.*;


public class CourseRecommender {
    private String url = "jdbc:sqlite:accounts.db";
    private String id;
    private ArrayList<String> recommendations;

    public CourseRecommender(String id) {
        this.id = id;
    }

    public ArrayList<String> completedCourses() throws SQLException {
        String courseID = "";
        ArrayList<String> completed = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt2 = conn.prepareStatement("SELECT courseID FROM enrollments WHERE studentID = ?");
        pstmt2.setString(1, LoginModel.getCurrentUser());
        ResultSet rs2 = pstmt2.executeQuery();
        while (rs2.next()) {
            courseID = rs2.getString("courseID");
            //System.out.println("Found a completed course");
            completed.add(rs2.getString("courseID"));
        }
        return completed;
    }

    public ArrayList<String> getEligible(ArrayList<String> completed) throws SQLException {
        ArrayList<String> eligibleCourses = new ArrayList<>();
        String prerequisite = "";
        String courseID = "";
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement("SELECT courseID, prerequisite_code FROM coursePrerequisites");

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            courseID = rs.getString("courseID");
            prerequisite = rs.getString("prerequisite_code");

            //Skip if the course is already completed
            if(completed.contains(courseID)) continue;

            if(prerequisite == null || prerequisite.isEmpty() || completed.contains(prerequisite)) {
                    if(!eligibleCourses.contains(courseID)) eligibleCourses.add(courseID);
            }
        }
        return eligibleCourses;
    }


    public String getStudentID() { return id;}

    public ArrayList<String> getRecommendations() { return recommendations != null ? recommendations : new ArrayList<String>(0);}
}
