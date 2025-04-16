package com.ksumobileapp.ScheduleBuilder;

import java.sql.*;
import java.util.*;
import com.ksumobileapp.ScheduleBuilder.EnrollmentModel;
import com.ksumobileapp.ScheduleBuilder.CourseModel;
import com.ksumobileapp.ScheduleBuilder.EnrollmentService;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;


public class CourseRecommender {
    private EnrollmentModel enrollmentModel;
    private EnrollmentService enrollmentService = new EnrollmentService();
    private String url = "jdbc:sqlite:accounts.db";


    public void connect(){
        try(Connection conn = DriverManager.getConnection(url);){

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> getRecommendedCourses(Connection conn, String studentId) throws SQLException {
        List<String> completed = new ArrayList<>();
        String major = "";
        String classification = "";
        String courseID = "";
        String prerequisite;


        //Get major and classification
        PreparedStatement pstmt1 = conn.prepareStatement("SELECT major, classification FROM `users` WHERE `studentID` = ?");
        pstmt1.setString(1, studentId);
        ResultSet rs = pstmt1.executeQuery();
        if (rs.next()) {
            major = rs.getString("major");
            classification = rs.getString("classification");
        }

        //Get completed courses
        PreparedStatement pstmt2 = conn.prepareStatement("SELECT courseID FROM `enrollments` WHERE `studentID` = ?");
        pstmt2.setString(1, studentId);
        ResultSet rs2 = pstmt2.executeQuery();
        while (rs2.next()) {
            courseID = rs2.getString("courseID");
            completed.add(rs2.getString("courseID"));
        }

        //Get eligible courses
        PreparedStatement pstmt3 = conn.prepareStatement("SELECT prerequisite_code FROM `coursePrerequisites`"
        + " WHERE `courseID` = ?");
        pstmt3.setString(1, courseID);
        ResultSet rs3 = pstmt3.executeQuery();

        List<String> recommendedCourses = new ArrayList<>();
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

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
