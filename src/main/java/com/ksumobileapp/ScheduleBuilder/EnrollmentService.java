package com.ksumobileapp.ScheduleBuilder;

import com.ksumobileapp.Login.LoginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentService {







/*
    public void enroll() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "INSERT INTO enrollments (studentID, courseID,courseName,credit,schedule,prefix,semester,time) VALUES (?, ?, ?, ?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentID);
            pstmt.setString(2, courseID);
            pstmt.setString(3, semester);
            pstmt.setString(4, status);

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public void unenroll() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "DELETE FROM enrollments WHERE studentID = ? and courseID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, this.studentID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
/*
    public void courseExists() {


    }

    public void getData(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT * FROM courses WHERE courseID = ?";
        String courseID;
        courseID = CourseModel.getCourseID();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            var rs = pstmt.executeQuery();
            if (rs.next()) {

                enrollmentModel.setStudentID(LoginModel.getCurrentUser());
                enrollmentModel.setCourseID(rs.getString("courseID"));
                enrollmentModel.setCourseName(rs.getString("courseName"));
                enrollmentModel.setCredit(rs.getString("credit"));
                enrollmentModel.setPrefix(rs.getString("prefix"));
                enrollmentModel.setSemester(rs.getString("semester"));
                enrollmentModel.setTime(rs.getString("time"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    public void setData() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "INSERT INTO enrollments() VALUES()";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,idGenerator(registerModel));



            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    }

     */


}

