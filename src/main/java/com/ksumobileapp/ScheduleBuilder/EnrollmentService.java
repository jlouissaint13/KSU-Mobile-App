package com.ksumobileapp.ScheduleBuilder;

import com.ksumobileapp.Login.LoginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentService {








    public void enroll(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "INSERT INTO enrollments (studentID, courseID,courseName,credit,prefix,semester,schedule) VALUES (?, ?, ?, ?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, LoginModel.getCurrentUser());
            pstmt.setString(2, CourseModel.getCourseID());
            pstmt.setString(3, enrollmentModel.getCourseName());
            pstmt.setString(4,enrollmentModel.getCredit());
            pstmt.setString(5,enrollmentModel.getPrefix());
            pstmt.setString(6,enrollmentModel.getSemester());
            pstmt.setString(7,enrollmentModel.getSchedule());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void unenroll() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "DELETE FROM enrollments WHERE studentID = ? and courseID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,LoginModel.getCurrentUser());
            pstmt.setString(2,CourseModel.getCourseID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void courseExists() {


    }

    public void getData(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT * FROM courses WHERE courseID = ?";
        String courseID;
        courseID = CourseModel.getCourseID();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,courseID);
            var rs = pstmt.executeQuery();
            if (rs.next()) {

                enrollmentModel.setStudentID(LoginModel.getCurrentUser());
                enrollmentModel.setCourseID(rs.getString(1));
                enrollmentModel.setCourseName(rs.getString("courseName"));
                enrollmentModel.setCredit(rs.getString("credit"));
                enrollmentModel.setPrefix(rs.getString("prefix"));
                enrollmentModel.setSemester(CourseModel.getSemester());
                enrollmentModel.setSchedule(rs.getString("schedule"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






    }






