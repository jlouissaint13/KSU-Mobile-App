package com.ksumobileapp.ScheduleBuilder;

import java.sql.*;
import java.util.*;
import com.ksumobileapp.ScheduleBuilder.EnrollmentService;
import com.ksumobileapp.ScheduleBuilder.CourseModel;
import com.ksumobileapp.Login.LoginModel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;


public class CourseRecommender {
    String url = "jdbc:sqlite:accounts.db";
    LoginModel loginModel;
    public String id = loginModel.getCurrentUser();
    public CourseModel courseModel;

    public void connect(){
        try(Connection conn = DriverManager.getConnection(url);){

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*public List<String> getRecommendedCourses(Connection conn, String studentId) throws SQLException {
        List<String> completed = new ArrayList<>();
        String major = "";
        String classification = "";


        //Get major and classification
        PreparedStatement pstmt1 = conn.prepareStatement("SELECT major, classification FROM `users` WHERE `studentID` = ?");
        pstmt1.setString(1, studentId);
        ResultSet rs = pstmt1.executeQuery();
        if (rs.next()) {
            major = rs.getString("major");
            classification = rs.getString("classification");
        }
    }*/

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
