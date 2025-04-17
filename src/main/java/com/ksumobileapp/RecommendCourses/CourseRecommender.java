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

    /*public void connect(){
        try(Connection conn = DriverManager.getConnection(url);){

        } catch (Exception e) {
            System.out.println("SQL Error");
        }
    }*/


    public ArrayList<String> completedCourses() throws SQLException {
        String courseID = "";
        ArrayList<String> completed = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt2 = conn.prepareStatement("SELECT courseID FROM enrollments WHERE studentID = ?");
        pstmt2.setString(1, LoginModel.getCurrentUser());
        ResultSet rs2 = pstmt2.executeQuery();
        while (rs2.next()) {
            courseID = rs2.getString("courseID");
            completed.add(rs2.getString("courseID"));
        }
        return completed;
    }

    public ArrayList<String> getEligible(ArrayList<String> completed) throws SQLException {
        ArrayList<String> eligibleCourses = new ArrayList<>();
        String prerequisite = "";
        String courseID = "";
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt3 = conn.prepareStatement("SELECT prerequisite_code FROM coursePrerequisites WHERE courseID = ?");
        for(int i =0; i < completed.size(); i++){
            pstmt3.setString(1, completed.get(i));
            ResultSet rs3 = pstmt3.executeQuery();
            while (rs3.next()){
                prerequisite = rs3.getString("prerequisite_code");
                courseID = rs3.getString("courseID");
                if(completed.contains(courseID)) continue;
                if(prerequisite == null || prerequisite.isEmpty() || completed.contains(prerequisite)) {
                    eligibleCourses.add(courseID);
                }
            }
        }
        return eligibleCourses;
    }



    public String getStudentID() { return id;}

    public ArrayList<String> getRecommendations() { return recommendations;}
}
