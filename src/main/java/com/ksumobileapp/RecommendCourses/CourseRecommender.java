package com.ksumobileapp.RecommendCourses;

import java.sql.*;
import java.util.*;


public class CourseRecommender {
    private String url = "jdbc:sqlite:accounts.db";
    private String id;
    private ArrayList<String> recommendations;

    public CourseRecommender(String id) {
        this.id = id;

    }

    public void connect(){
        try(Connection conn = DriverManager.getConnection(url);){
            recommendations = recommend(conn, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<String> recommend(Connection conn, String studentId) throws SQLException {
        List<String> completed = new ArrayList<>();
        String major = "";
        String classification = "";
        String courseID = "";
        String prerequisite;


        //Get major and classification
        PreparedStatement pstmt1 = conn.prepareStatement("SELECT major, classification FROM users WHERE studentID = ?");
        pstmt1.setString(1, studentId);
        ResultSet rs = pstmt1.executeQuery();
        if (rs.next()) {
            major = rs.getString("major");
            classification = rs.getString("classification");
        }

        //Get completed courses
        PreparedStatement pstmt2 = conn.prepareStatement("SELECT courseID FROM enrollments WHERE studentID = ?");
        pstmt2.setString(1, studentId);
        ResultSet rs2 = pstmt2.executeQuery();
        while (rs2.next()) {
            courseID = rs2.getString("courseID");
            completed.add(rs2.getString("courseID"));
        }

        //Get eligible courses
        PreparedStatement pstmt3 = conn.prepareStatement("SELECT prerequisite_code FROM coursePrerequisites WHERE courseID = ?");
        pstmt3.setString(1, courseID);
        ResultSet rs3 = pstmt3.executeQuery();

        ArrayList<String> recommendedCourses = new ArrayList<>();
        while (rs3.next()) {
            prerequisite = rs3.getString("prerequisite_code");
            courseID = rs3.getString("courseID");
            if(completed.contains(courseID)) continue;
            if(prerequisite == null || prerequisite.isEmpty() || completed.contains(prerequisite)) {
                recommendedCourses.add(courseID);
            }
        }
        return recommendedCourses;
    }

    public String getStudentID() { return id;}

    public ArrayList<String> getRecommendations() { return recommendations;}
}
